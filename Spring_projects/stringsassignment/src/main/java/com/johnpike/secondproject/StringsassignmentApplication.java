package com.johnpike.secondproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsassignmentApplication.class, args);
	}

	@RequestMapping("/")
	public String hello() {
		return "Hello Client! How are you doing?";
	}

	@RequestMapping("/random")
	public String respond() {
		return "Spring Boot sucks my ASS! Run while you can.";
	}
}
