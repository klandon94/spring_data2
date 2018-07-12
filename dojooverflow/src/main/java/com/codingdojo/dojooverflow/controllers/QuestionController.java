package com.codingdojo.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService qServ;
	private final TagService tServ;
	private final AnswerService aServ;
	
	public QuestionController(QuestionService qServ, TagService tServ, AnswerService aServ) {
		this.qServ = qServ;
		this.tServ = tServ;
		this.aServ = aServ;
	}
	
	@RequestMapping("")
	public String dashboard(Model model) {
		List<Question> questions = qServ.allQuestions();
		model.addAttribute("questions", questions);
		return "allquestions.jsp";
	}
	
	@RequestMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question question, Model model) {
		return "newquestion.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createQuestion(@RequestParam("question") String question, @RequestParam("tags") String tags, RedirectAttributes redAttr) {
		tags = tags.replaceAll(" ", "");
		String pat1 = "([a-z]+, ?)+[a-z]+";
		String pat2 = "[a-z]+";
		if (question.equals("")) {
			redAttr.addFlashAttribute("questionerror", "Please enter a question");
			return "redirect:/questions/new";
		}
		if (!tags.matches(pat1) && !tags.matches(pat2)) {
			redAttr.addFlashAttribute("tagerror", "Tags must be lowercase and separated by commas");
			return "redirect:/questions/new";
		}
		String[] newTags = tags.split(",");
		if (newTags.length > 3) {
			redAttr.addFlashAttribute("tagerror", "Only 3 tags are allowed");
			return "redirect:/questions/new";
		}
		List<Tag> addTags = new ArrayList<Tag>();
		for (String x : newTags) {
			if (tServ.findTag(x) != null) addTags.add(tServ.findTag(x));
			else {
				Tag t = new Tag(x);
				tServ.createTag(t);
				addTags.add(t);
			}
		}
		Question newQuestion = new Question(question, addTags);
		qServ.createQuestion(newQuestion);
		redAttr.addFlashAttribute("questionsuccess", "Successfully asked a question");
		return "redirect:/questions";
	}
	
	@RequestMapping("/{id}")
	public String oneQuestion(@ModelAttribute("answer") Answer answer, Model model, @PathVariable("id") Long id) {
		Question question = qServ.getQuestion(id);
		model.addAttribute("question", question);
		return "onequestion.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String createAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult res, @PathVariable("id") Long id, Model model) {
		if (res.hasErrors()) {
			Question question = qServ.getQuestion(id);
			model.addAttribute("question", question);
			return "onequestion.jsp";
		}
		else {
			aServ.createAnswer(answer);
			return "redirect:/questions/"+id;
		}
	}
	
	
}
