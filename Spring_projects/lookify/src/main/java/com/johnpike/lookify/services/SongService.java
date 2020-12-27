package com.johnpike.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnpike.lookify.models.Song;
import com.johnpike.lookify.repositories.SongRepository;

@Service
public class SongService {
	private static SongRepository songRepo;

	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}

	public Song Create(Song newSong) {
		return songRepo.save(newSong);
	}

	public List<Song> getAll() {
		return (List<Song>) songRepo.findAll();
	}

	public Song getOne(Long id) {
		Optional<Song> song = songRepo.findById(id);
		return song.isPresent() ? song.get() : null;
	}

	public Song update(Song toUpdate, Long id) {
		return songRepo.save(toUpdate);
	}

	public void destroy(Song toDelete, Long id) {
		songRepo.delete(toDelete);
	}

	public List<Song> search(String search) {
		return songRepo.findByTitleContaining(search);
	}

	public List<Song> top10songs() {
		return songRepo.top10songs();
	}
}
