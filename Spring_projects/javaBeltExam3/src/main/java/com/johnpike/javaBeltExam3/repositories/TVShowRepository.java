package com.johnpike.javaBeltExam3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.javaBeltExam3.models.TVShow;

@Repository
public interface TVShowRepository extends CrudRepository<TVShow, Long> {

}
