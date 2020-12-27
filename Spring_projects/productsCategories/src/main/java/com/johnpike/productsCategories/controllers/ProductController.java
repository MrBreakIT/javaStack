package com.johnpike.productsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnpike.productsCategories.models.Category;
import com.johnpike.productsCategories.models.Product;
import com.johnpike.productsCategories.services.ProductService;

@Controller
public class ProductController {

	// using ProductService allows us to save things to the DB
	private static ProductService prodServ;

	public ProductController(ProductService prodServ) {
		this.prodServ = prodServ;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newProduct", new Product()); // used for the product form
		model.addAttribute("newCategory", new Category()); // used for the category form
		model.addAttribute("allProducts", prodServ.getProducts());
		model.addAttribute("allCategories", prodServ.getCategories());
		return "index.jsp";
	}

	@PostMapping("/product")
	public String addProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result,
			Model model) { // BindingResult brings in the validations
		if (result.hasErrors()) {
			model.addAttribute("newCategory", new Category()); // Will's Valid's worked w/o this
			return "index.jsp";
		} else {
			prodServ.create(newProduct); // this creates the new Product
			return "redirect:/";
		}
	}

	@PostMapping("/category")
	public String addCategory(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("newProduct", new Product());
			return "index.jsp";
		} else {
			prodServ.create(newCategory);
			return "redirect:/";
		}
	}

	@PostMapping("/addCategoryToProduct")
	public String addCategoryToProduct(@RequestParam("product_id") Long productId,
			@RequestParam("category_id") Long categoryId) {
		// want to get back both the product and category below
		Product theProduct = prodServ.getProduct(productId);
		Category theCategory = prodServ.getCategory(categoryId);
		// then add List category to the list of products //then tie product to the
		// categories and add it
		List<Category> productCategory = theProduct.getCategories();
		productCategory.add(theCategory);
		// game is updated, now save it inside Service file and below
		prodServ.saveProduct(theProduct);
		return "redirect:/";
	}

	@GetMapping("/showProduct/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model, Product newProduct) {
		model.addAttribute("newCategory", new Category());
		model.addAttribute("allCats", prodServ.getCategories());
		model.addAttribute("product", prodServ.getProduct(id));
		return "showProduct.jsp";
	}

}