package com.johnpike.javaBeltExam2.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.johnpike.javaBeltExam2.models.Idea;
import com.johnpike.javaBeltExam2.models.User;
import com.johnpike.javaBeltExam2.services.IdeaService;
import com.johnpike.javaBeltExam2.services.UserService;

@Controller
public class IdeaController {

	private final IdeaService ideaService;
	private final UserService userService;

	public IdeaController(IdeaService ideaService, UserService userService) {
		this.ideaService = ideaService;
		this.userService = userService;
	}

//	HOME PAGE
	@GetMapping("/ideas")
	public String index(HttpSession session, Model model) {
//		FIND USER BY ID
		Long u_id = (Long) session.getAttribute("u_id");
		User u = userService.findUserById(u_id);
		model.addAttribute("user", u);
//    	FIND ALL IDEAS
		List<Idea> allIdeas = ideaService.findAll();
		model.addAttribute("allIdeas", allIdeas);
		return "index.jsp";
	}

//	CREATE NEW IDEA PAGE
	@GetMapping("/ideas/new")
	public String createPage(@Valid @ModelAttribute("newidea") Idea newidea) {
		return "create.jsp";
	}

//	CREATE NEW IDEA
	@PostMapping("/ideas/new")
	public String create(@Valid @ModelAttribute("newidea") Idea newidea, BindingResult result, HttpSession session) {
//		FIND USER BY ID
		Long u_id = (Long) session.getAttribute("u_id");
		User u = userService.findUserById(u_id);
//    	CREATE IDEA
		if (result.hasErrors()) {
			return "create.jsp";
		} else {
			newidea.setCreator(u);
			ideaService.createIdea(newidea);
			return "redirect:/ideas";
		}

	}

//	IDEA INFO
	@GetMapping("/ideas/{id}")
	public String info(@PathVariable("id") Long id, Model model) {
//		GET IDEA BY ID
		Idea idea = ideaService.findIdeaById(id);
		model.addAttribute("idea", idea);
		return "info.jsp";
	}

//	IDEA EDIT PAGE
	@GetMapping("/ideas/{id}/edit")
	public String editPage(@PathVariable("id") Long id, @Valid @ModelAttribute("updatedidea") Idea updatedidea,
			HttpSession session, Model model) {
//		GET IDEA BY ID
		Idea idea = ideaService.findIdeaById(id);
		model.addAttribute("idea", idea);
//		GET USER
		Long u_id = (Long) session.getAttribute("u_id");
//		CHECK USER VS CREATOR
		if (idea.getCreator().getId().equals(u_id)) {
			return "edit.jsp";
		} else {
			return "redirect:/ideas";
		}

	}

//	IDEA EDIT
	@PutMapping("/ideas/{id}/edit")
	public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute("updatedidea") Idea updatedidea,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("error");
			return "redirect:/ideas/" + id + "/edit";
		} else {
			Long u_id = (Long) session.getAttribute("u_id");
			User u = userService.findUserById(u_id);
			updatedidea.setCreator(u);
			ideaService.updateIdea(updatedidea);
			return "redirect:/ideas";
		}
	}

//	DELETE IDEA
	@DeleteMapping("/ideas/{id}")
	public String destroy(@PathVariable("id") Long id) {
		ideaService.deleteIdea(id);
		return "redirect:/ideas";
	}

//	LIKE IDEA
	@PostMapping("/ideas/{id}/like")
	public String like(@PathVariable("id") Long id, HttpSession session) {
//		GET IDEA BY ID
		Idea idea = ideaService.findIdeaById(id);
//		FIND USER BY ID
		Long u_id = (Long) session.getAttribute("u_id");
		User u = userService.findUserById(u_id);
//    	LIKE IDEA
		List<User> likedIdeas = idea.getLikedUser();
		likedIdeas.add(u);
		idea.setLikedUser(likedIdeas);
		ideaService.updateIdea(idea);
		return "redirect:/ideas";
	}

//	UNLIKE IDEA
	@PostMapping("/ideas/{id}/unlike")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
//		GET IDEA BY ID
		Idea idea = ideaService.findIdeaById(id);
//		FIND USER BY ID
		Long u_id = (Long) session.getAttribute("u_id");
		User u = userService.findUserById(u_id);
//    	LIKE IDEA
		List<User> likedIdeas = idea.getLikedUser();
		likedIdeas.remove(u);
		idea.setLikedUser(likedIdeas);
		ideaService.updateIdea(idea);
		return "redirect:/ideas";
	}

}
