package com.johnpike.games.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnpike.games.models.DateExample;

@Controller
public class DateExampleController {

	@GetMapping("/dateExample")
	public String dateExample(Model model) {
		model.addAttribute("newDateExample", new DateExample());
		return "dateExample.jsp";
	}

	@PostMapping("/dateExample")
	public String partyForm(@Valid @ModelAttribute("newDateExample") DateExample newDateExample, BindingResult result) {

		// we can check for .before() or .after()
		if (newDateExample.getStart().before(new Date())) {
			result.rejectValue("start", "inPast", "Cannot plan party in the PAST!");
		}
		if (result.hasErrors()) {
			return "dateExample.jsp";
		}
		return "redirect:/dateExample";
	}
}