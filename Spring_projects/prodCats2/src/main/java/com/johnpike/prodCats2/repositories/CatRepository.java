package com.johnpike.prodCats2.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.prodCats2.models.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

	Optional<Cat> findCatByName(String name);
}
