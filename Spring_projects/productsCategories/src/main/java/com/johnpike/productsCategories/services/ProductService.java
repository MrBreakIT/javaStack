package com.johnpike.productsCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnpike.productsCategories.models.Category;
import com.johnpike.productsCategories.models.Product;
import com.johnpike.productsCategories.repositories.CategoryRepository;
import com.johnpike.productsCategories.repositories.ProductRepository;

@Service
public class ProductService {
	// Service needs to reference the Repo's created
	private static ProductRepository prodRepo;
	private static CategoryRepository catRepo;

	public ProductService(ProductRepository prodRepo, CategoryRepository catRepo) {
		this.prodRepo = prodRepo;
		this.catRepo = catRepo;
	}

	// can use 2 create methods because 2 different arguments- Product & Category
	public Product create(Product newProduct) {
		return prodRepo.save(newProduct);
	}

	public Category create(Category newCategory) {
		return catRepo.save(newCategory);
	}

	// list casted in (List<Product>)
	public List<Product> getProducts() {
		return (List<Product>) prodRepo.findAll();
	}

	// list casted in (List<Category>)
	public List<Category> getCategories() {
		return (List<Category>) catRepo.findAll();
	}

	// getters and setters
	// we need to define and bring in both category and product
	public Category getCategory(Long id) {
		Optional<Category> category = catRepo.findById(id);
		return category.isPresent() ? category.get() : null;
	}

	public Product getProduct(Long id) {
		Optional<Product> product = prodRepo.findById(id);
		return product.isPresent() ? product.get() : null;
	}

	// methods to save product and category
	public Product saveProduct(Product product) {
		return prodRepo.save(product);
	}

	public Category saveCat(Category cat) {
		return catRepo.save(cat);
	}

}
