package com.johnpike.javaBeltExam.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "Email is required")
	@Email(message = "Invalid Email!")
	private String email;

	@NotEmpty(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters.")
	private String password;

	@NotEmpty(message = "Confirm Password is required")
	@Transient // Transient means we don't want it stored/saved in DB, we just want it to exist
				// to call on to validate
	private String confirmPW;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<LikedIdea> likedIdeas;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ideas_likes", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "idea_id"))
	private List<LikedIdea> likes;

	// this is my zero argument constructor
	public User() {
	}

	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPW() {
		return confirmPW;
	}

	public void setConfirmPW(String confirmPW) {
		this.confirmPW = confirmPW;
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

	// this brings in a list of LikedIdea
	public List<LikedIdea> getIdeas() {
		return likedIdeas;
	}

	public void setIdeas(List<LikedIdea> likedIdeas) {
		this.likedIdeas = likedIdeas;
	}

	// this brings in a list of Likes
	public List<LikedIdea> getLikes() {
		return likes;
	}

	public void setLikes(List<LikedIdea> likes) {
		this.likes = likes;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
