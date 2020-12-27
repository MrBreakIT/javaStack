package com.johnpike.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
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

	@RequestMapping("/counter")
	public String counterPage(Model model, HttpSession session) {
		return "counter.jsp";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		return "redirect:/";
	}

	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("pageViews");
		return "redirect:/";
	}
}
