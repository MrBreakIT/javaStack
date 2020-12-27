package com.johnpike.javaBeltExam3.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnpike.javaBeltExam3.models.Review;
import com.johnpike.javaBeltExam3.models.TVShow;
import com.johnpike.javaBeltExam3.models.User;
import com.johnpike.javaBeltExam3.services.ShowService;

@Controller
public class HomeController {

	private static ShowService showServ;

	public HomeController(ShowService showServ) {
		this.showServ = showServ;
	}

	// alternative / better ? way to create games WITH genres
	// lets user upload a game WITH a genre and we're displaying games
	@GetMapping("/home")
	public String newShowPlus(Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user"); // need to 'cast' this b/c whatever in session is an
																	// object (so tell it to be user again)
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("title", "All TV-Shows!");
		model.addAttribute("newShowPlus", new TVShow());
		model.addAttribute("allShows", showServ.getTVShow());
		return "show.jsp";
	}

	@PostMapping("/shows/new")
	public String createShowWithNetworks(@Valid @ModelAttribute("newShowPlus") TVShow newShowPlus, BindingResult result,
			Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("allShows", showServ.getTVShow());
			return "show.jsp";
		} else {
			User loggedInUser = (User) session.getAttribute("user");
			newShowPlus.setUser(loggedInUser);
			showServ.createShowWithNetworks(newShowPlus);
			return "redirect:/home";
		}
	}

	@GetMapping("/show/{id}")
	public String showTVShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		// if user is not logged in, this method kicks them to login screen
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("someShow", showServ.getTVShow(id));
		model.addAttribute("newReview", new Review());
		return "review.jsp";
	}

	@PostMapping("/show/{id}/review")
	public String reviewShow(@Valid @ModelAttribute("newReview") Review newReview, BindingResult result,
			@PathVariable("id") Long id, Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (result.hasErrors()) {
			model.addAttribute("someShow", showServ.getTVShow(id));
			return "review.jsp";
		}
		newReview.setTVShow(showServ.getTVShow(id));
		newReview.setUser(loggedInUser);
		Review r = showServ.create(newReview);
		if (r == null) {
			result.rejectValue("rating", "unique", "You have already this TV Show!");
			model.addAttribute("someShow", showServ.getTVShow(id));
			return "review.jsp";
		}
		return "redirect:/show/" + id;
	}

	// this method is to find all games of a certain genre
	@GetMapping("/network/{network}")
	public String showsInNetworks(@PathVariable("network") String network, Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("title", "Network: " + network);
		model.addAttribute("newShowPlus", new TVShow());
		model.addAttribute("allShows", showServ.showsInNetworks(network));
		return "show.jsp";
	}
}
