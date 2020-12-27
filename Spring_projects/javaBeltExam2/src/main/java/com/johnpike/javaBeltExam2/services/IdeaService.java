package com.johnpike.javaBeltExam2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.johnpike.javaBeltExam2.models.Idea;
import com.johnpike.javaBeltExam2.repositories.IdeaRepository;

@Service
public class IdeaService {

	private final IdeaRepository ideaRepo;

	public IdeaService(IdeaRepository ideaRepo) {
		this.ideaRepo = ideaRepo;
	}

	public Idea createIdea(@Valid Idea newidea) {
		return ideaRepo.save(newidea);

	}

	public List<Idea> findAll() {
		return ideaRepo.findAll();
	}

	public Idea findIdeaById(Long id) {
		Optional<Idea> idea = ideaRepo.findById(id);

		if (idea.isPresent()) {
			return idea.get();
		} else {
			return null;
		}
	}

	public Idea updateIdea(@Valid Idea updatedidea) {
		return ideaRepo.save(updatedidea);

	}

	public void deleteIdea(Long id) {
		ideaRepo.deleteById(id);

	}

}
