package com.johnpike.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	@Query(value = "SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery = true)

	List<Song> top10songs();

	List<Song> findByTitleContaining(String search);

}
