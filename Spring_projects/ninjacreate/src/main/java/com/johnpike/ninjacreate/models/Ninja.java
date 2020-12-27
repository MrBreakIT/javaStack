package com.johnpike.ninjacreate.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity /* tells java this is saving to a DB */
@Table(name = "ninjas") /* name however but this creates table in DB */
public class Ninja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, message = "Name must be longer than 2 characters.")
	private String name;

	@Size(min = 4, message = "Hometown must be longer than 2 characters.")
	private String hometown;

	@Min(value = 0, message = "Power level must be greater than 0!")
	private Integer level;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// cascade so we don't error when deleting a ninja...techs depend on the ninja
	// fetch has to do with a left or right join
	@OneToMany(mappedBy = "ninja", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Technique> techniques;

	// this is the constructor
	public Ninja() {
	}

	// below are the getters/setters
	public String getName() {
		return name;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<Technique> getTechniques() {
		return techniques;
	}

	public void setTechniques(List<Technique> techniques) {
		this.techniques = techniques;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public String toString() {
		return name + " | " + hometown + " | " + level;
	}

}
