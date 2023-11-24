package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Long>{

}
