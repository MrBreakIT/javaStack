package com.johnpike.javaBeltExam3.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.javaBeltExam3.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	// wanna be able to look up a user based on the email given
	Optional<User> findByEmail(String email); // email references User model email

}