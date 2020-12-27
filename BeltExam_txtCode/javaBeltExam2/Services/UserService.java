package com.johnpike.javaBeltExam2.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.johnpike.javaBeltExam2.models.User;
import com.johnpike.javaBeltExam2.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

//	REGISTER USER HASH PASSWORD
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}

//  AUTHENTICATE USER
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

//FIND USER BY EMAIL
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

//	FIND USER BY ID
	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);

		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

//	UPDATE USER
	public void updateUser(User u) {
		userRepo.save(u);
	}

}
