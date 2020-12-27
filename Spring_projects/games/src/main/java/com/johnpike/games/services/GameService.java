package com.johnpike.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnpike.games.models.Game;
import com.johnpike.games.models.Genre;
import com.johnpike.games.models.Review;
import com.johnpike.games.repositories.GameRepository;
import com.johnpike.games.repositories.GenreRepository;
import com.johnpike.games.repositories.ReviewRepository;

@Service
public class GameService {

	private static GameRepository gameRepo;
	private static GenreRepository genreRepo;
	private static ReviewRepository revRepo;

	public GameService(GameRepository gameRepo, GenreRepository genreRepo, ReviewRepository revRepo) {
		this.gameRepo = gameRepo;
		this.genreRepo = genreRepo;
		this.revRepo = revRepo;
	}

	public Game create(Game newGame) {
		return gameRepo.save(newGame);
	}

	public Genre create(Genre newGenre) {
		return genreRepo.save(newGenre);
	}

//make sure user has NOT already reviewed that game
	public Review create(Review newReview) {
		List<Review> matchingReviews = revRepo.matchingReviews(newReview.getUser().getId(),
				newReview.getGame().getId());
		if (matchingReviews.size() > 0) {
			return null;
		}
		newReview.setId(null);
		return revRepo.save(newReview);
	}

	public List<Genre> getGenres() {
		return (List<Genre>) genreRepo.findAll();
	}

	public List<Game> getGames() {
		return (List<Game>) gameRepo.findAll();
	}

	public Genre getGenre(Long id) {
		Optional<Genre> genre = genreRepo.findById(id);
		return genre.isPresent() ? genre.get() : null;
	}

	public Game getGame(Long id) {
		Optional<Game> game = gameRepo.findById(id);
		return game.isPresent() ? game.get() : null;
	}

	public Game saveGame(Game game) {
		return gameRepo.save(game);
	}

	public Genre createOrRetrieve(String genreName) {
		Optional<Genre> mightExist = genreRepo.findGenreByName(genreName);
		if (mightExist.isPresent()) {
			return mightExist.get();
		} else {
			return genreRepo.save(new Genre(genreName));
		}
	}

	public Game createGameWithGenres(Game newGamePlus) {
		List<Genre> genres = new ArrayList<Genre>();
		for (String genreName : newGamePlus.getGenresInput().split(",")) {
			genres.add(createOrRetrieve(genreName));
		}
		newGamePlus.setGenres(genres);
		return gameRepo.save(newGamePlus);
	}

	// this is the method finding games of a certain genre
	public List<Game> gamesInGenre(String genre) {
		Optional<Genre> g = genreRepo.findGenreByName(genre);
		return g.isPresent() ? g.get().getGames() : new ArrayList<Game>();
	}

}