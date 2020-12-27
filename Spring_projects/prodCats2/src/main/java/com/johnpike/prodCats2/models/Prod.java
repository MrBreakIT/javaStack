package com.johnpike.prodCats2.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "products")
public class Prod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Product name is required")
	private String name;

	@Size(min = 5, max = 255, message = "Description required between 5-255 characters.")
	private String description;

	@NotNull(message = "Current price is required")
	private Double price;

	// Transient used to just have available but not stored/saved in DB (used also
	// for confirming PW)-- We use this to generate a form with both product AND
	// category
	@Transient
	private String categoryInput;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "prod_id"), inverseJoinColumns = @JoinColumn(name = "cat_id"))
	// this is the other model file imported to here
	// this List<Cat> field exists so Java knows about the Category table inside
	// Product model
	private List<Cat> cat;

	// this is the 0 arg constructor
	public Prod() {
	}

	public List<Cat> getCats() {
		return cat;
	}

	public void setCats(List<Cat> cats) {
		this.cat = cats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getCategoryInput() {
		return categoryInput;
	}

	public void setCategoryInput(String categoryInput) {
		this.categoryInput = categoryInput;
	}

	public List<Cat> getCategories() {
		return cat;
	}

	public void setCategories(List<Cat> category) {
		this.cat = category;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// categoryDescription()function turns the Object on the jsp to a String for
	// readability... this is a custom method

	public String categoryDescription() {
//		String result = "";
//		for (Category c : categories) {
//			result += c.getName() + ", ";
//		}
//		return result;
//	}
		// ---for loop below removes hanging comma at end of string---
		String result = "";
		for (int i = 0; i < cat.size(); i++) {
			result += cat.get(i).getName();
			if (i < cat.size() - 1) {
				result += ", ";
			}
		}
		return result;
	}
}
