package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Medecin;

@Repository
public interface MedecinRepository extends CrudRepository<Medecin, Long>{

}
