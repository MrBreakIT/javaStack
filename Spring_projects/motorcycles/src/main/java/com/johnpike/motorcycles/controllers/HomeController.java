package com.johnpike.motorcycles.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	public static ArrayList<String> motorcycle;

	public HomeController() {
		motorcycle = new ArrayList<String>();
		motorcycle.add("GSXR 750");
		motorcycle.add("Ducati 996");
		motorcycle.add("Yamaha R1");
		motorcycle.add("DM-014 Droog");
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("date", new Date());
		model.addAttribute("bikes", motorcycle);
		return "index.jsp";
	}

	@RequestMapping("/new")
	public String newBike(@RequestParam(value = "name") String name) {
//		type in browser- new?name= <then enter new motorcycle> but these disappear on refresh
		motorcycle.add(name);
		return "redirect:/";
	}

	// example of query-parameters
	@RequestMapping("/view/{id}")
	public String view(@PathVariable(value = "id") Integer id, Model model) {
		System.out.println(motorcycle.get(id));
		return "redirect:/";
//		return "view.jsp";
	}

}
