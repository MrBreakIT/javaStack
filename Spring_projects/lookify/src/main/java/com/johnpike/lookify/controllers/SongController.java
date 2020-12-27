package com.johnpike.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnpike.lookify.models.Artist;
import com.johnpike.lookify.models.Song;
import com.johnpike.lookify.services.ArtistService;
import com.johnpike.lookify.services.SongService;

@Controller
public class SongController {
	private static SongService songserv;
	private static ArtistService artistserv;

	public SongController(SongService songserv, ArtistService artistserv) {
		this.songserv = songserv;
		this.artistserv = artistserv;
	}

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/dashboard")
	public String dashboard(@RequestParam(value = "search", required = false) String search, Model model) {
		if (search == null) {
			model.addAttribute("song", songserv.getAll());
//			model.addAttribute("artist", artistserv.getAll());
		} else {
			model.addAttribute("song", songserv.search(search));
//			model.addAttribute("artist", artistserv.search(search));
		}
		return "dashboard.jsp";
	}

	@GetMapping("/songs/new")
	public String newSong(Model model) {
		model.addAttribute("newSong", new Song());
		return "newSong.jsp";
	}

	@PostMapping("/create/song")
	public String createSong(@Valid @ModelAttribute("newSong") Song newSong, BindingResult result, Model model) {
		if (result.hasFieldErrors()) {
			model.addAttribute("song", songserv.getAll());
			return "newSong.jsp";
		} else {
			songserv.Create(newSong);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/artist/new")
	public String newArtist(Model model) {
		model.addAttribute("newArtist", new Artist());
		return "newArtist.jsp";
	}

	@PostMapping("/create/artist")
	public String createArtist(@Valid @ModelAttribute("newArtist") Song newArtist, BindingResult result, Model model) {
		if (result.hasFieldErrors()) {
			model.addAttribute("artist", songserv.getAll());
			return "newArtist.jsp";
		} else {
			songserv.Create(newArtist);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/song/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songserv.getOne(id));
		return "showSong.jsp";
	}

	@GetMapping("/artist/{id}")
	public String showArtist(@PathVariable("id") Long id, Model model) {
		model.addAttribute("artist", artistserv.getOne(id));
		return "showArtist.jsp";
	}

	@GetMapping("/edit/song/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("singleSong", songserv.getOne(id));
		return "editSong.jsp";
	}

	@PostMapping("/edit/update/{id}")
	public String updateSong(@PathVariable("id") Long id, @Valid @ModelAttribute("singleSong") Song singleSong,
			BindingResult result) {
		if (result.hasErrors()) {
			return "editSong.jsp";
		} else {
			songserv.update(singleSong, id);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/song/destroy/{id}")
	public String destroy(@PathVariable("id") Long id, @Valid @ModelAttribute("singleSong") Song singleSong,
			BindingResult result) {
		songserv.destroy(singleSong, id);
		return "redirect:/dashboard";
	}

	@GetMapping("/songs/top/10")
	public String top10songs(Model model) {
		model.addAttribute("songs", songserv.top10songs());
		return "topCharts.jsp";
	}
}
