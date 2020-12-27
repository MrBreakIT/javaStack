package com.johnpike.games.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

@Service
public class LoginUser {

	@NotEmpty(message = "Email required")
	@Email(message = "Invalid Email")
	private String email;

	@NotEmpty(message = "Password required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;

	// this is zero argument constructor... then create getters/setters
	public LoginUser() {
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

}
