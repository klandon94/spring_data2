package com.codingdojo.relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.PersonLicenseService;

@Controller
public class PersonLicenseController {
	private final PersonLicenseService serv;
	
	public PersonLicenseController(PersonLicenseService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("persons/new")
	public String index(Model model) {
		model.addAttribute("person", new Person());
		return "personlicense/newperson.jsp";
	}
	
	@RequestMapping(value="persons/new", method=RequestMethod.POST)
	public String createPerson(@ModelAttribute("person") Person person) {
		serv.createPerson(person);
		return "redirect:/persons/new";
	}
	
	@RequestMapping("licenses/new")
	public String index2(Model model) {
		model.addAttribute("persons", serv.allPersons());
		return "personlicense/newlicense.jsp";
	}
	
	@RequestMapping(value="licenses/new", method=RequestMethod.POST)
	public String createLicense(@RequestParam("person") String person, @RequestParam("state") String state, @RequestParam("date") Date date){ //throws ParseException
		// Date newDate = new SimpleDateFormat("MM/d/yyy").parse(date);
		Person p = serv.findPerson(Long.valueOf(person));
		License license = new License(p, state, date);
		license.setNumber("00000" + String.valueOf(p.getId()));
		p.setLicense(license);
		serv.createLicense(license);
		return "redirect:/licenses/new";
	}
	
	@RequestMapping("persons/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Person p = serv.findPerson(id);
		model.addAttribute("person", p);
		return "personlicense/showperson.jsp";
	}
	
	

}
