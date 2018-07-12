package com.codingdojo.relationships.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Dojo;
import com.codingdojo.relationships.models.Ninja;
import com.codingdojo.relationships.repositories.DojoRepository;
import com.codingdojo.relationships.repositories.NinjaRepository;

@Service
@Transactional
public class DojoNinjaService {
	private final DojoRepository dojoRepo;
	@Autowired
	private final NinjaRepository ninjaRepo;
//	static variable to set the number of ninjas that we want per page
	private static final int PAGE_SIZE = 3;
	
	public DojoNinjaService(DojoRepository dojo, NinjaRepository ninja) {
		dojoRepo = dojo;
		ninjaRepo = ninja;
	}
	
	public ArrayList<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else return null;
	}
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
	
	
//	Added as part of Advanced Queries section
	public List<Object[]> joinDojosNinjas() {
		return dojoRepo.joinDojosAndNinjas2();
	}
	
	public Page<Ninja> ninjasPerPage(int pageNumber){
//		get all the ninjas page and sort them in ascending order the last name property
		PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lastName");
		Page<Ninja> ninjas = ninjaRepo.findAll(pageRequest);
		return ninjaRepo.findAll(pageRequest);
	}
	
	
	public ArrayList<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else return null;
	}
	public void deleteNinja(Long id) {
		dojoRepo.deleteById(id);
	}
	
	
}
