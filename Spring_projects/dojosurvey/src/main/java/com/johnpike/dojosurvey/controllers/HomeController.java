package com.johnpike.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnpike.dojosurvey.model.FormModel;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}

	@PostMapping("/survey/validate")
	public String validate(@ModelAttribute(value = "form") FormModel form, HttpSession session) {
		System.out.println(form.name + " " + form.location + " " + form.language + " " + form.comment + " ");
		session.setAttribute("name", form.name);
		session.setAttribute("location", form.location);
		session.setAttribute("language", form.language);
		session.setAttribute("comment", form.comment);
		return "redirect:/survey/result";
	}

	@RequestMapping("/survey/result")
	public String result(Model model, HttpSession session) {
		session.getAttribute("name");
		session.getAttribute("location");
		session.getAttribute("language");
		session.getAttribute("comment");
		return "result.jsp";
	}

}
