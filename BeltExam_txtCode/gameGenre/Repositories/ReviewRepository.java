package com.johnpike.games.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.games.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

	@Query(value = "SELECT * FROM reviews WHERE user_id = ?1 AND game_id = ?2", nativeQuery = true)
	List<Review> matchingReviews(Long user_id, Long game_id);

}