package com.johnpike.javaBeltExam2.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnpike.javaBeltExam2.models.User;
import com.johnpike.javaBeltExam2.services.UserService;
import com.johnpike.javaBeltExam2.validator.UserValidator;

@Controller
public class UserController {

	private final UserService userService;
	private final UserValidator userValidator;

	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@GetMapping("/")
	public String signIn(@ModelAttribute("user") User user) {
		return "signIn.jsp";
	}

//  REGISTER USER
	@PostMapping(value = "/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "signIn.jsp";
		}
		User u = userService.registerUser(user);
		session.setAttribute("u_id", u.getId());
		return "redirect:/ideas";
	}

//LOGIN USER
	@PostMapping(value = "/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session, @ModelAttribute("user") User user) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("u_id", u.getId());
			return "redirect:/ideas";
		} else {
			model.addAttribute("error", "Invalid Credentials");
			return "signIn.jsp";
		}
	}

//	LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
