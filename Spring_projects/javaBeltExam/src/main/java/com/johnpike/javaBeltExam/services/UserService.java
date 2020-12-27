package com.johnpike.javaBeltExam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.johnpike.javaBeltExam.models.User;
import com.johnpike.javaBeltExam.repositories.UserRepository;

@Service
public class UserService {

	private static UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User registerUser(User registeringUser) {
		String hashed = BCrypt.hashpw(registeringUser.getPassword(), BCrypt.gensalt());
		registeringUser.setPassword(hashed);
		return userRepo.save(registeringUser);

	}

	public boolean authenticateUser(String email, String password) {
		// first find the user by email
		User user = userRepo.findByEmail(email);
		// if we can't find it by email, return false
		if (user == null) {
			return false;
		} else {
			// if the passwords match, return true, else, return false
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);

		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	public void updateUser(User u) {
		userRepo.save(u);
	}

}
