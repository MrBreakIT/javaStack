package com.johnpike.games.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnpike.games.models.Example;

@Controller
public class ExampleController {

	@GetMapping("/example")
	public String examplePage(Model model) {
		model.addAttribute("newExample", new Example());
		return "example.jsp";
	}

	@PostMapping("/example")
	public String partyForm(@Valid @ModelAttribute("newExample") Example newExample, BindingResult result) {
		// we can check for .before() or .after()
		if (newExample.getStart().before(new Date())) {
			result.rejectValue("start", "inPast", "You cannot plan a party in the past!");
		}
		if (result.hasErrors()) {
			return "example.jsp";
		}
		return "redirect:/example";
	}

}