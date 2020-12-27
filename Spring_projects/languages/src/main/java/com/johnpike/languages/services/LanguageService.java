package com.johnpike.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnpike.languages.models.LanguageModel;
import com.johnpike.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private static LanguageRepository langRepo;

	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}

	public LanguageModel create(LanguageModel newLang) {
		return langRepo.save(newLang);
	}

	public List<LanguageModel> getAll() {
		return (List<LanguageModel>) langRepo.findAll();
	}

	public LanguageModel getOne(Long id) {
		Optional<LanguageModel> lang = langRepo.findById(id);
		return lang.isPresent() ? lang.get() : null;
	}

	public LanguageModel update(LanguageModel toUpdate, Long id) {
		return langRepo.save(toUpdate);
	}

	public void destroy(LanguageModel toDelete, Long id) {
		langRepo.delete(toDelete);
	}
}