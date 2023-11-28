package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}

