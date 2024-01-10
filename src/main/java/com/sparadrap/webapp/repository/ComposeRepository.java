package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Compose;

public interface ComposeRepository extends CrudRepository<Compose, Long> {

}
