package com.johnpike.javaBeltExam.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.javaBeltExam.models.Idea;

@Repository
public interface LikeRepository extends CrudRepository<Idea, Long> {
	Optional<Idea> findLikeByName(String name);
}
