package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Specialiste;

@Repository
public interface SpecialisteRepository extends CrudRepository<Specialiste, Long>{

}
