package com.johnpike.javaBeltExam2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.javaBeltExam2.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

}