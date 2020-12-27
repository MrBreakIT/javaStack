package com.johnpike.games.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.johnpike.games.models.LoginUser;
import com.johnpike.games.models.User;
import com.johnpike.games.repositories.UserRepository;

@Service
public class UserService {

	private static UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User create(User registeringUser) {
		String hashed = BCrypt.hashpw(registeringUser.getPassword(), BCrypt.gensalt());
		registeringUser.setPassword(hashed);
		return userRepo.save(registeringUser);

	}

//this is 2nd getUser used to see User profile
	public User getUser(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}

	public User getUser(String email) {
		Optional<User> potentialUser = userRepo.findByEmail(email);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}

	public User login(LoginUser loginUser, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		User existingUser = getUser(loginUser.getEmail());
		if (existingUser == null) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}
		if (!BCrypt.checkpw(loginUser.getPassword(), existingUser.getPassword())) {
			result.rejectValue("password", "matches", "Incorrect Password!");
			return null;
		}
		return existingUser;
	}
}
