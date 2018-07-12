package com.codingdojo.relationships.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Dojo;
import com.codingdojo.relationships.models.Ninja;
import com.codingdojo.relationships.repositories.DojoRepository;
import com.codingdojo.relationships.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
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
