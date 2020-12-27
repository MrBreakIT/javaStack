package com.johnpike.ninjacreate.services;

import org.springframework.stereotype.Service;

import com.johnpike.ninjacreate.models.Technique;
import com.johnpike.ninjacreate.repositories.TechniqueRepository;

@Service
public class TechniqueService {

	private static TechniqueRepository techRepo;

	public TechniqueService(TechniqueRepository techRepo) {
		this.techRepo = techRepo;
	}

	public Technique create(Technique newTech) {
		return techRepo.save(newTech);
	}
}
