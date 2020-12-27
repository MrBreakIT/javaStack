package com.johnpike.javaBeltExam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ideas_likes")
public class LikedIdea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idea_id")
	private Idea idea;

//	@OneToMany(mappedBy = "idea", fetch = FetchType.LAZY)
//	private List<Like> likes;

	// this is the Zero arg constructor
	public LikedIdea() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
//	public String genreDescription() {
//		String result = "";
//		for (int i = 0; i < genres.size(); i++) {
//			result += genres.get(i).getName();
//			if (i < genres.size() - 1) {
//				result += ", ";
//			}
//		}
//		return result;
//	}
//
//	public Double getAverageRating() {
//		if (reviews.size() == 0) {
//			return 0d;
//		}
//		Double total = 0d;
//		for (Review r : reviews) { // refers to List<Reviews> above in model
//			total += r.getRating();
//		}
//		return Math.floor(total / reviews.size());
//	}

}
