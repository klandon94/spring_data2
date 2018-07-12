package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository aRepo;
	
	public AnswerService(AnswerRepository aRepo) {
		this.aRepo = aRepo;
	}
	
	public List<Answer> allAnswers(){
		return aRepo.findAll();
	}
	
	public Answer createAnswer(Answer a) {
		return aRepo.save(a);
	}
	
	public Answer getAnswer(Long id) {
		Optional<Answer> optionalAnswer = aRepo.findById(id);
		if (optionalAnswer.isPresent()) return optionalAnswer.get();
		else return null;
	}
	
}
