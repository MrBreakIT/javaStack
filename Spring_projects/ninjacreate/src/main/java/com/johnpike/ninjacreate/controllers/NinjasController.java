package com.johnpike.ninjacreate.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.johnpike.ninjacreate.models.Ninja;
import com.johnpike.ninjacreate.models.Technique;
import com.johnpike.ninjacreate.services.NinjaService;
import com.johnpike.ninjacreate.services.TechniqueService;

@Controller
public class NinjasController {

	private static NinjaService ninServ;
	private static TechniqueService techServ;

	public NinjasController(NinjaService ninServ, TechniqueService techServ) {
		this.ninServ = ninServ;
		this.techServ = techServ;
	}

	@GetMapping("/")
	public String index(@RequestParam(value = "search", required = false) String search, Model model) {
		System.out.println(search);
		if (search == null) {
			model.addAttribute("ninjas", ninServ.getAll());
		} else {
			model.addAttribute("ninjas", ninServ.search(search));
		}
		model.addAttribute("newNinja", new Ninja());
		return "index.jsp";
	}

	@PostMapping("/ninja")
	public String create(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// if invalid re-render the page and pass along
			// any models that the page needs (like a list of ninja for the table)
			model.addAttribute("ninjas", ninServ.getAll());
			return "index.jsp";
		} else {
			// if the ninja is valid save them to the DB
			// and then redirect
			ninServ.create(newNinja);
			return "redirect:/";
		}
	}

	@GetMapping("/ninja/{id}")
	public String ninjaDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("singleNinja", ninServ.getOne(id));
		return "ninja.jsp";
	}

	@GetMapping("ninja/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ninja", ninServ.getOne(id));
		return "ninjadetails.jsp";

	}

	@PostMapping("/ninja/update/{id}")
	public String updateNinja(@PathVariable("id") Long id, @Valid @ModelAttribute("singleNinja") Ninja singleNinja,
			BindingResult result) {
		if (result.hasErrors()) {
			return "ninja.jsp";
		} else {
			ninServ.update(singleNinja, id);
			return "redirect:/";
		}
	}

	@GetMapping("/ninja/destroy/{id}")
	public String destroy(@PathVariable("id") Long id, @Valid @ModelAttribute("singleNinja") Ninja singleNinja,
			BindingResult result) {
		ninServ.destroy(singleNinja, id);
		return "redirect:/";
	}

	@GetMapping("ninjas/top/3")
	public String top3(Model model) {
		model.addAttribute("ninjas", ninServ.top3ninjas());
		return "topNinjas.jsp";
	}

	@GetMapping("/techs/new")
	public String newTechs(Model model) {
		model.addAttribute("allNinjas", ninServ.getAll());
		model.addAttribute("newTech", new Technique());
		return "newTech.jsp";
	}

	@PostMapping("/techs")
	public String addTechs(@Valid @ModelAttribute("newTech") Technique newTech, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allNinjas", ninServ.getAll());
			return "newTech.jsp";
		}
		techServ.create(newTech);
		return "redirect:/";
	}

	@PostMapping("/addtech")
	public String addTechAgain(@RequestParam("name") String name, @RequestParam("ninja") Long ninja_id,
			RedirectAttributes flash) {
		Technique jutsu = new Technique(name);
		if (name.length() < 3) {
			flash.addFlashAttribute("nameError", "Technique name must be longer than 3 characters.");
			return "redirect:/ninja/" + ninja_id;
		}
		jutsu.setNinja(ninServ.getOne(ninja_id));
		techServ.create(jutsu);
		return "redirect:/ninja/" + ninja_id;
	}
}
