package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository qRepo;
	
	public QuestionService(QuestionRepository qRepo) {
		this.qRepo = qRepo;
	}
	
	public List<Question> allQuestions(){
		return qRepo.findAll();
	}
	
	public Question createQuestion(Question q) {
		return qRepo.save(q);
	}
	
	public Question getQuestion(Long id) {
		Optional<Question> optionalQuestion = qRepo.findById(id);
		if (optionalQuestion.isPresent()) return optionalQuestion.get();
		else return null;
	}
	
}
