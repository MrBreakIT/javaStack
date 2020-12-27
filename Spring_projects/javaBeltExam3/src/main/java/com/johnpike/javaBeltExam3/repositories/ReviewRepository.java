package com.johnpike.javaBeltExam3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.javaBeltExam3.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	@Query(value = "SELECT * FROM reviews WHERE user_id = ?1 AND show_id = ?2", nativeQuery = true)
	List<Review> matchingReviews(Long user_id, Long game_id);
}
