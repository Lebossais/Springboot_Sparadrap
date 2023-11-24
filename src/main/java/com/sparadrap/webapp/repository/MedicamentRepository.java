package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Medicament;

@Repository
public interface MedicamentRepository extends CrudRepository<Medicament, Long>{

}
