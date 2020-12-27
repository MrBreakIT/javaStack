package com.johnpike.games.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Title is required!")
	private String title;

	@NotEmpty(message = "Studio is required!")
	private String studio;

	@NotNull(message = "Year released is required!")
	private Integer year;

	@Transient
	private String genresInput;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "games_genres", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres;

	// this is the game that will be reviewed...(TODO- make sure mappedBy is review
	// or game?!
	@OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
	private List<Review> reviews;

	// this is the single user that uploaded the game
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	// this is zero argument constructor... then create getters/setters
	public Game() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getGenresInput() {
		return genresInput;
	}

	public void setGenresInput(String genresInput) {
		this.genresInput = genresInput;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public String genreDescription() {
		String result = "";
		for (int i = 0; i < genres.size(); i++) {
			result += genres.get(i).getName();
			if (i < genres.size() - 1) {
				result += ", ";
			}
		}
		return result;
	}

	public Double getAverageRating() {
		if (reviews.size() == 0) {
			return 0d;
		}
		Double total = 0d;
		for (Review r : reviews) { // refers to List<Reviews> above in model
			total += r.getRating();
		}
		return Math.floor(total / reviews.size());
	}

}