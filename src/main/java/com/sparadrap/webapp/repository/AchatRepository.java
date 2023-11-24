package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Achat;

@Repository
public interface AchatRepository extends CrudRepository<Achat, Long> {

}
