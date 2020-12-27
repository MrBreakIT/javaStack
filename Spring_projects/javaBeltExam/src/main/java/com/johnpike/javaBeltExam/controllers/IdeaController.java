package com.johnpike.javaBeltExam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.johnpike.javaBeltExam.models.Game;
import com.johnpike.javaBeltExam.models.Review;
import com.johnpike.javaBeltExam.models.User;
import com.johnpike.javaBeltExam.services.GameService;

@Controller
public class HomeController {

	private static GameService gameServ;

	public HomeController(GameService gameServ) {
		this.gameServ = gameServ;
	}

	// alternative / better ? way to create games WITH genres
	// lets user upload a game WITH a genre and we're displaying games
	@GetMapping("/home")
	public String newGamePlus(Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user"); // need to 'cast' this b/c whatever in session is an
																	// object (so tell it to be user again)
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("title", "All Games!");
		model.addAttribute("newGamePlus", new Game());
		model.addAttribute("allGames", gameServ.getGames());
		return "game.jsp";
	}

	@PostMapping("games/new")
	public String createGameWithGenres(@Valid @ModelAttribute("newGamePlus") Game newGamePlus, BindingResult result,
			Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("allGames", gameServ.getGames());
			return "game.jsp";
		} else {
			User loggedInUser = (User) session.getAttribute("user");
			newGamePlus.setUser(loggedInUser);
			gameServ.createGameWithGenres(newGamePlus);
			return "redirect:/home";
		}
	}

	@GetMapping("/game/{id}")
	public String showGame(@PathVariable("id") Long id, Model model, HttpSession session) {
		// if user is not logged in, this method kicks them to login screen
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("someGame", gameServ.getGame(id));
		model.addAttribute("newReview", new Review());
		return "review.jsp";
	}

	@PostMapping("/game/{id}/review")
	public String reviewGame(@Valid @ModelAttribute("newReview") Review newReview, BindingResult result,
			@PathVariable("id") Long id, Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (result.hasErrors()) {
			model.addAttribute("someGame", gameServ.getGame(id));
			return "review.jsp";
		}
		// TODO- otherwise save review and redirect
		newReview.setGame(gameServ.getGame(id));
		newReview.setUser(loggedInUser);
		Review r = gameServ.create(newReview);
		if (r == null) {
			result.rejectValue("content", "unique", "You have already this game!");
			model.addAttribute("someGame", gameServ.getGame(id));
			return "review.jsp";
		}
		return "redirect:/game/" + id;
	}

	// this method is to find all games of a certain genre
	@GetMapping("/genre/{genre}")
	public String gamesInGenre(@PathVariable("genre") String genre, Model model, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser == null) {
			return "redirect:/";
		}
		model.addAttribute("title", "Genre: " + genre);
		model.addAttribute("newGamePlus", new Game());
		model.addAttribute("allGames", gameServ.gamesInGenre(genre));
		return "game.jsp";
	}
}

//	@GetMapping("/")
//	public String index(Model model) {
//		model.addAttribute("newGame", new Game());
//		model.addAttribute("newGenre", new Genre());
//		model.addAttribute("allGames", gameServ.getGames());
//		model.addAttribute("allGenres", gameServ.getGenres());
//		return "index.jsp";
//	}

//	@PostMapping("/games")
//	public String newGame(@Valid @ModelAttribute("newGame") Game newGame, BindingResult result) {
//		if (result.hasErrors()) {
//			return "index.jsp";
//		} else {
//			gameServ.create(newGame);
//			return "redirect:/";
//		}
//	}

//	@PostMapping("/genres")
//	public String newGame(@Valid @ModelAttribute("newGenre") Genre newGenre, BindingResult result) {
//		if (result.hasErrors()) {
//			return "index.jsp";
//		} else {
//			gameServ.create(newGenre);
//			return "redirect:/";
//		}
//	}

//	@PostMapping("/add_genre")
//	public String addGenreToGame(@RequestParam("game_id") Long gameid, @RequestParam("genre_id") Long genreid) {
//		Game theGame = gameServ.getGame(gameid);
//		Genre theGenre = gameServ.getGenre(genreid);
//		List<Genre> gameGenres = theGame.getGenres();
//		gameGenres.add(theGenre);
//		gameServ.saveGame(theGame);
//		return "redirect:/";
//	}