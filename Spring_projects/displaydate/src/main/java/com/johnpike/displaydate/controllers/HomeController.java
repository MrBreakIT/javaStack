package com.johnpike.displaydate.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//	@RequestMapping("/")
//	public String index(Model model) {
//		return "index.jsp";
//	}

	@RequestMapping("/date")
	public String date(Model model) {
		model.addAttribute("date", new Date());
		return "date.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		model.addAttribute("time", new Date());
		return "time.jsp";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		return "redirect:/";
	}

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
}
