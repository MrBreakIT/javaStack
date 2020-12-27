package com.johnpike.prodCats2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.prodCats2.models.Prod;

@Repository
public interface ProdRepository extends CrudRepository<Prod, Long> {

}
