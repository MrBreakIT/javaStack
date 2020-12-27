package com.johnpike.prodCats2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnpike.prodCats2.models.Cat;
import com.johnpike.prodCats2.models.Prod;
import com.johnpike.prodCats2.repositories.CatRepository;
import com.johnpike.prodCats2.repositories.ProdRepository;

@Service
public class ProdService {
	// Service needs to reference the Repo's created
	private static ProdRepository prodRepo;
	private static CatRepository catRepo;

	public ProdService(ProdRepository prodRepo, CatRepository catRepo) {
		this.prodRepo = prodRepo;
		this.catRepo = catRepo;
	}

	// can use 2 create methods because 2 different arguments- Product & Category
	public Prod create(Prod newProduct) {
		return prodRepo.save(newProduct);
	}

	public Cat create(Cat newCategory) {
		return catRepo.save(newCategory);
	}

	// list casted in (List<Product>)
	public List<Prod> getProducts() {
		return (List<Prod>) prodRepo.findAll();
	}

	// list casted in (List<Category>)
	public List<Cat> getCategories() {
		return (List<Cat>) catRepo.findAll();
	}

	// getters and setters
	// we need to define and bring in both category and product
	public Cat getCategory(Long id) {
		Optional<Cat> category = catRepo.findById(id);
		return category.isPresent() ? category.get() : null;
	}

	public Prod getProduct(Long id) {
		Optional<Prod> product = prodRepo.findById(id);
		return product.isPresent() ? product.get() : null;
	}

	// see if Cat exists before creating entry for it
	public Cat createOrRetrieve(String catName) {
		Optional<Cat> mightExist = catRepo.findCatByName(catName);
		if (mightExist.isPresent()) {
			return mightExist.get();
		} else {
			return catRepo.save(new Cat(catName));
		}

	}

	// will save to products table same time as category table
	public Prod createProductWithCategory(Prod newProductPlus) {
		List<Cat> cats = new ArrayList<Cat>();
		for (String catName : newProductPlus.getCategoryInput().split(",")) {
			cats.add(createOrRetrieve(catName));
		}
		newProductPlus.setCats(cats);
		return prodRepo.save(newProductPlus);
	}

	// methods to save product and category
	public Prod saveProduct(Prod product) {
		return prodRepo.save(product);
	}

	public Cat saveCat(Cat cat) {
		return catRepo.save(cat);
	}

}
