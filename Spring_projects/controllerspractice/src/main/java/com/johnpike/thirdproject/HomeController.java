package com.johnpike.thirdproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/m/{track}/{module}/{lesson}")
	public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module,
			@PathVariable("lesson") String lesson) {
		return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;

	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hey World! What route did you use to get here? But really, How'd you know?";
	}

	@RequestMapping("/goodbye")
	public String world() {
		return "Goodbye world!";
	}
}
