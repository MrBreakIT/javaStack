package com.johnpike.prodCats2.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnpike.prodCats2.models.Prod;
import com.johnpike.prodCats2.services.ProdService;

@Controller
public class ProdController {

	// using ProductService allows us to save things to the DB
	private static ProdService prodServ;

	public ProdController(ProdService prodServ) {
		this.prodServ = prodServ;
	}

//	@GetMapping("/")
//	public String index(Model model) {
//		model.addAttribute("newProduct", new Prod()); // used for the product form
//		model.addAttribute("newCategory", new Cat()); // used for the category form
//		model.addAttribute("allProducts", prodServ.getProducts());
//		model.addAttribute("allCategories", prodServ.getCategories());
//		return "index.jsp";
//	}

//	@PostMapping("/product")
//	public String addProduct(@Valid @ModelAttribute("newProduct") Prod newProduct, BindingResult result, Model model) {
//		// Binding result brings in the validations
//		if (result.hasErrors()) {
//			model.addAttribute("newCategory", new Cat()); // Will's Valid's worked w/o this
//			return "index.jsp";
//		} else {
//			prodServ.create(newProduct); // this creates the new Product
//			return "redirect:/";
//		}
//	}

//	@PostMapping("/category")
//	public String addCategory(@Valid @ModelAttribute("newCategory") Cat newCategory, BindingResult result,
//			Model model) {
//		if (result.hasErrors()) {
//			model.addAttribute("newProduct", new Prod());
//			return "index.jsp";
//		} else {
//			prodServ.create(newCategory);
//			return "redirect:/";
//		}
//	}

//	@PostMapping("/addCategoryToProduct")
//	public String addCategoryToProduct(@RequestParam("product_id") Long productId,
//			@RequestParam("category_id") Long categoryId) {
//		// want to get back both the product and category below
//		Prod theProduct = prodServ.getProduct(productId);
//		Cat theCategory = prodServ.getCategory(categoryId);
//		// then add List category to the list of products //then tie product to the
//		// categories and add it
//		List<Cat> productCategory = theProduct.getCategories();
//		productCategory.add(theCategory);
//		// game is updated, now save it inside Service file and below
//		prodServ.saveProduct(theProduct);
//		return "redirect:/";
//	}

	@GetMapping("/")
	public String newProductPlus(Model model) {
		model.addAttribute("newProductPlus", new Prod());
		model.addAttribute("allProducts", prodServ.getProducts());
		return "index.jsp"; // change product.jsp back to index.jsp
	}

	@PostMapping("/")
	public String createProductWithCategory(@Valid @ModelAttribute("newProductPlus") Prod newProductPlus,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allProducts", prodServ.getProducts());
			return "index.jsp";
		} else {
			prodServ.createProductWithCategory(newProductPlus);
			return "redirect:/";
		}
	}
}
