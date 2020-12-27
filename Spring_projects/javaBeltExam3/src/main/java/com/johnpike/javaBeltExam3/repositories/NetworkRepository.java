package com.johnpike.javaBeltExam3.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.javaBeltExam3.models.Network;

@Repository
public interface NetworkRepository extends CrudRepository<Network, Long> {
	Optional<Network> findNetworkByName(String name);
}
