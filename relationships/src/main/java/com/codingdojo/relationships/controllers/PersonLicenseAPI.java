package com.codingdojo.relationships.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.services.PersonLicenseService;

@RestController
@RequestMapping("/api")
public class PersonLicenseAPI {
	private final PersonLicenseService serv;
	
	public PersonLicenseAPI(PersonLicenseService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("/persons")
	public ArrayList<Person> index(){
		return serv.allPersons();
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.POST)
	public Person create(@RequestParam(value="first") String firstName, @RequestParam(value="last") String lastName) {
		Person person = new Person(firstName, lastName);
		return serv.createPerson(person);
	}
	
	@RequestMapping("/persons/{id}")
    public Person show(@PathVariable("id") Long id) {
        Person person = serv.findPerson(id);
        return person;
    }
	
	@RequestMapping(value="/licenses")
	public ArrayList<License> index2(){
		return serv.allLicenses();
	}
	
	@RequestMapping("/licenses/{id}")
    public License show2(@PathVariable("id") Long id) {
        License license = serv.findLicense(id);
        return license;
    }
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public License create(@RequestParam(value="person") Long id, @RequestParam(value="state") String state, @RequestParam(value="date") Date date) {
		Person person = serv.findPerson(id);
		License license = new License(person, state, date);
		license.setNumber("00000" + String.valueOf(person.getId()));
		person.setLicense(license);
		return serv.createLicense(license);
	}
	
}
