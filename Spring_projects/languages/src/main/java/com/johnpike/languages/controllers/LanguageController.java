package com.johnpike.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnpike.languages.models.LanguageModel;
import com.johnpike.languages.services.LanguageService;

@Controller
public class LanguageController {
	private static LanguageService langserv;

	public LanguageController(LanguageService langserv) {
		this.langserv = langserv;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("lang", langserv.getAll());
		model.addAttribute("newLang", new LanguageModel());
		return "index.jsp";
	}

	@PostMapping("/create/language")
	public String create(@Valid @ModelAttribute("newLang") LanguageModel newLang, BindingResult result, Model model) {
		if (result.hasFieldErrors()) {
			model.addAttribute("languages", langserv.getAll());
			return "index.jsp";
		} else {
			langserv.create(newLang);
			System.out.println(newLang);
			return "redirect:/";
		}
	}

	@GetMapping("/edit/language/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("singleLang", langserv.getOne(id));
//		System.out.println(langserv.getOne(id));
		return "edit.jsp";
	}

	@PostMapping("/edit/update/{id}")
	public String updateLang(@PathVariable("id") Long id, @Valid @ModelAttribute("singleLang") LanguageModel singleLang,
			BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			langserv.update(singleLang, id);
			return "redirect:/";
		}
	}

	@GetMapping("/language/destroy/{id}")
	public String destroy(@PathVariable("id") Long id, @Valid @ModelAttribute("singleLang") LanguageModel singleLang,
			BindingResult result) {
		langserv.destroy(singleLang, id);
		return "redirect:/";
	}

	@GetMapping("language/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", langserv.getOne(id));
		return "show.jsp";
	}

}