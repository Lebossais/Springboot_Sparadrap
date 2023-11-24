package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Ordonnance;

@Repository
public interface OrdonnanceRepository extends CrudRepository<Ordonnance, Long> {

}
