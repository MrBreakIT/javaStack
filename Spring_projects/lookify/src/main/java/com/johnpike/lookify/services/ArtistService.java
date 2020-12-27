package com.johnpike.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnpike.lookify.models.Artist;
import com.johnpike.lookify.repositories.ArtistRepository;

@Service
public class ArtistService {
	private static ArtistRepository artistRepo;

	public ArtistService(ArtistRepository artistRepo) {
		this.artistRepo = artistRepo;
	}

	public Artist create(Artist newArtist) {
		return artistRepo.save(newArtist);
	}

	public List<Artist> getAll() {
		return (List<Artist>) artistRepo.findAll();

	}

	public Artist getOne(Long id) {
		Optional<Artist> artist = artistRepo.findById(id);
		return artist.isPresent() ? artist.get() : null;
	}

	public Artist update(Artist toUpdate, Long id) {
		return artistRepo.save(toUpdate);
	}

	public void destroy(Artist toDelete, Long id) {
		artistRepo.delete(toDelete);
	}

}