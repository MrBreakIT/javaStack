package com.johnpike.javaBeltExam3.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnpike.javaBeltExam3.models.LoginUser;
import com.johnpike.javaBeltExam3.models.Review;
import com.johnpike.javaBeltExam3.models.TVShow;
import com.johnpike.javaBeltExam3.models.User;
import com.johnpike.javaBeltExam3.services.ShowService;
import com.johnpike.javaBeltExam3.services.UserService;

@Controller
public class UserController {

	private static UserService userServ;
	private static ShowService showServ;

	public UserController(UserService userServ, ShowService showServ) {
		this.userServ = userServ;
		this.showServ = showServ;
	}

	@GetMapping("/")
	public String signIn(Model model) {
		model.addAttribute("registeringUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "signIn.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registeringUser") User registeringUser, BindingResult result,
			Model model, HttpSession session) {
		if (!registeringUser.getPassword().equals(registeringUser.getConfirmPW())) {
			result.rejectValue("confirm", "Match", "Confirm Password must match Password!");
		}
		if (userServ.getUser(registeringUser.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email already in use!");
		}

		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "signIn.jsp";
		} else {
			session.setAttribute("user", userServ.create(registeringUser));
			return "redirect:/home";
		}
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model,
			HttpSession session) {
		User loggingInUser = userServ.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("registeringUser", new User());
			return "signIn.jsp";
		} else {
			session.setAttribute("user", loggingInUser);
			return "redirect:/home";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}

	// page where user can see all their review & see what shows they didn't review
	@GetMapping("/user")
	public String userProfile(HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		User userFromDB = userServ.getUser(loggedInUser.getId());
		model.addAttribute("user", userFromDB);
		// create a list of games we haven't yet reviewed...
		List<TVShow> otherShows = showServ.getTVShow();
		for (Review r : userFromDB.getReviews()) {
			otherShows.remove(r.getTVShow());
		}
		model.addAttribute("showsToReview", otherShows);
		return "userProfile.jsp";
	}

}
