package com.johnpike.lookify.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.lookify.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
