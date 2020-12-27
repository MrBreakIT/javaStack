package com.johnpike.ninjacreate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johnpike.ninjacreate.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	// this is the interface NOT class

	@Query(value = "SELECT * FROM ninjas ORDER BY level DESC LIMIT 3", nativeQuery = true)
	List<Ninja> top3ninjas();

	List<Ninja> findByNameContaining(String search);

	List<Ninja> findByHometownContaining(String search);
}

// query search for Lookify assignment
//@Query(value="SELECT * FROM some WHERE artist LIKE %?1%, nativeQuery=true")
//List<Song> search (String search);