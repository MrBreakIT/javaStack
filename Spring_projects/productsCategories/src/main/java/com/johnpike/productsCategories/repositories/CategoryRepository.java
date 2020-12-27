package com.johnpike.productsCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.productsCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
