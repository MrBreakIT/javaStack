package com.johnpike.productsCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.productsCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}