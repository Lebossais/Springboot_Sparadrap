package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Personne;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long>{

}
