package com.johnpike.games.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.games.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
	Optional<Genre> findGenreByName(String name);
}
