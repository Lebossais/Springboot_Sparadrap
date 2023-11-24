package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Mutuelle;

@Repository
public interface MutuelleRepository extends CrudRepository<Mutuelle, Long>{

}
