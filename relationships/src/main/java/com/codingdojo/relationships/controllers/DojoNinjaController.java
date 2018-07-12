package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.Dojo;
import com.codingdojo.relationships.models.Ninja;
import com.codingdojo.relationships.services.DojoNinjaService;

@Controller
public class DojoNinjaController {
	private final DojoNinjaService serv;
	
	public DojoNinjaController(DojoNinjaService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("dojos/new")
	public String index(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "dojoninja/newdojo.jsp";
	}
	
	@RequestMapping(value="dojos/new", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult res) {
		if (res.hasErrors()) return "dojoninja/newdojo.jsp";
		serv.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("ninjas/new")
	public String index2(Model model) {
		model.addAttribute("dojos", serv.allDojos());
		return "dojoninja/newninja.jsp";
	}
	
	@RequestMapping(value="ninjas/new", method=RequestMethod.POST)
	public String createNinja(@RequestParam("dojo") Long id, @RequestParam("fName") String fName, @RequestParam("lName") String lName, @RequestParam("age") int age) {
		Dojo d = serv.findDojo(id);
		Ninja n = new Ninja(d, fName, lName, age);
		d.getNinjas().add(n);
		serv.createNinja(n);
		return "redirect:/ninjas/new";
	}
	
	@RequestMapping("dojos/{id}")
	public String showDojo(Model model, @PathVariable("id") Long id) {
		Dojo d = serv.findDojo(id);
		if (d == null) {
			return "redirect:/dojos/new";
		}
		List<Ninja> ninjas = d.getNinjas();
		model.addAttribute("dojo", d);
		model.addAttribute("ninjas", ninjas);
		return "dojoninja/showdojo.jsp";
	}
	
	@RequestMapping("dojosninjas")
	public String showDojosNinjas(Model model) {
		List<Object[]> table = serv.joinDojosNinjas();
//		To unpackage data, cast each index of the array of objects to the expecting class. If using the query in view, JSP automatically casts the type for you
//		for (Object[] row: table) {
//			Dojo dojo = (Dojo) row[0];
//			Ninja ninja = (Ninja) row[1];
//		}
		model.addAttribute("table", table);
		return "dojoninja/dojosninjas.jsp";
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
//		we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax
		Page<Ninja> ninjas = serv.ninjasPerPage(pageNumber - 1);
//		total number of pages that we have
		int totalPages = ninjas.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("ninjas", ninjas);
		return "dojoninja/ninjapages.jsp";
	}
	
}
