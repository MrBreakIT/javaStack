package com.johnpike.ninjacreate.repositories;

import org.springframework.data.repository.CrudRepository;

import com.johnpike.ninjacreate.models.Technique;

public interface TechniqueRepository extends CrudRepository<Technique, Long> {

}
