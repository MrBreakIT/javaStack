package com.johnpike.thecode.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	public static ArrayList<String> bestGuess;

	public HomeController() {
		bestGuess = new ArrayList<String>();
	}

	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		model.addAttribute("bestGuess", bestGuess);
		Integer views = (Integer) session.getAttribute("pageViews");
		if (views == null) {
			session.setAttribute("pageViews", 1);
			views = 0;
		}
		views++;
		session.setAttribute("pageViews", views);
		model.addAttribute("pageViews", views);
		return "index.jsp";
	}

	@RequestMapping("/code")
	public String code(@RequestParam(value = "code") String name) {
		String red = "redirect:/";
		if (name.equals("bushido")) {
			red = "redirect:/code/page";
		} else {
			bestGuess.add(name);
		}
		return red;
	}

	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("pageViews");
		return "redirect:/";
	}

	@RequestMapping("/code/page")
	public String home(Model model) {
		bestGuess = new ArrayList<String>();
		return "code.jsp";
	}
}
