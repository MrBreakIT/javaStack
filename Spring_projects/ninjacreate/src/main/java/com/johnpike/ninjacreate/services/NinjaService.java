package com.johnpike.ninjacreate.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnpike.ninjacreate.models.Ninja;
import com.johnpike.ninjacreate.repositories.NinjaRepository;

@Service
public class NinjaService {

	private static NinjaRepository ninjaRepo; // this ninjaRepo is how we connect to DB

	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	public Ninja create(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}

	public List<Ninja> getAll() {
		return (List<Ninja>) ninjaRepo.findAll();
	}

	public Ninja getOne(Long id) {
		// Optional protects us from asking for something that doesn't exist in DB
		// like asking for Ninja id=100 (doesn't exist)
		Optional<Ninja> ninja = ninjaRepo.findById(id);
//		if (ninja.isPresent()) {
//			return ninja.get();
//		} else {
//			return null;       //below is the ternary for this if statement
//		}
		return ninja.isPresent() ? ninja.get() : null;
	}

	public Ninja update(Ninja toUpdate, Long id) {
		return ninjaRepo.save(toUpdate);
	}

	public void destroy(Ninja toDelete, Long id) {
		ninjaRepo.delete(toDelete);
	}

	public List<Ninja> top3ninjas() {
		return ninjaRepo.top3ninjas();
	}

	public List<Ninja> search(String search) {
		List<Ninja> byName = ninjaRepo.findByNameContaining(search);
		List<Ninja> byTown = ninjaRepo.findByHometownContaining(search);
		ArrayList<Ninja> toReturn = new ArrayList<Ninja>();
		for (Ninja n : byTown) {
			byName.add(n);
		}
		return byName;
	}
}
