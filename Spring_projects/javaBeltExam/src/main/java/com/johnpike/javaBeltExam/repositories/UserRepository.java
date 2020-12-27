package com.johnpike.javaBeltExam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.javaBeltExam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	// wanna be able to look up a user based on the email given
	User findByEmail(String email); // email references User model email

}
