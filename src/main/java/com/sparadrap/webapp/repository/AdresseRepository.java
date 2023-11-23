package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Adresse;

@Repository
public interface AdresseRepository extends CrudRepository<Adresse, Long>{
	
}
