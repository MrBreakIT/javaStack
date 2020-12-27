package com.johnpike.games.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.games.models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

	// this is an INTERFACE not CLASS
}
