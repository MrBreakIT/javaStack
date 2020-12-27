package com.johnpike.languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.languages.models.LanguageModel;

@Repository
public interface LanguageRepository extends CrudRepository<LanguageModel, Long> {

}
