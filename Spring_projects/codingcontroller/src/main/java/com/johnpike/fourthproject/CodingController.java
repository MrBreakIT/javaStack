package com.johnpike.fourthproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	@RequestMapping("/")
	public String hello() {
		return "Hello";
	}

	@RequestMapping("/coding")
	public String coding() {
		return "Hey CodingDojo World!";
	}

	@RequestMapping("/coding/python")
	public String python() {
		return "Python/Django was awesome!";
	}

	@RequestMapping("/coding/java")
	public String java() {
		return "Java/Spring is NOT better!";
	}
}
