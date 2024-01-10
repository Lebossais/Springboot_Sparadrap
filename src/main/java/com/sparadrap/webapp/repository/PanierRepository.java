package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Panier;

public interface PanierRepository extends CrudRepository<Panier, Long>{

}
