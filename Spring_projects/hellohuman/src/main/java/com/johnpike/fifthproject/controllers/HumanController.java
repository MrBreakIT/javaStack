package com.johnpike.fifthproject.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
//	@RequestMapping("/")
//	public String hello() {
//		return "Hello HUMAN!";
//	}

	@RequestMapping("/")
	public String greeting(@RequestParam(value = "q", required = false) String searchQuery) {
		if (searchQuery == null) {
			return "Hello HUMAN!";
		} else {
			return "Hello " + searchQuery + "!";
		}
	}

	@RequestMapping("/{name}-{lname}")
	public String personalGreeting(@PathVariable("name") String name, @PathVariable("lname") String lname) {
		return "Hello " + name + " " + lname + "!" + "\n" + "\n" + "Welcome to SpringBoot!";
	}
}
