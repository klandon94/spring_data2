package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tRepo;
	
	public TagService(TagRepository tRepo) {
		this.tRepo = tRepo;
	}
	
	public List<Tag> allTags(){
		return tRepo.findAll();
	}
	
	public Tag createTag(Tag a) {
		return tRepo.save(a);
	}
	
	public Tag findTag(String t) {
		return tRepo.findFirstBySubject(t);
	}
	
	public Tag getTag(Long id) {
		Optional<Tag> optionalTag = tRepo.findById(id);
		if (optionalTag.isPresent()) return optionalTag.get();
		else return null;
	}
	
}
