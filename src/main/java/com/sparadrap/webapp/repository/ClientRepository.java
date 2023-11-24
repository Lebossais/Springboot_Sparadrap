package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

}
