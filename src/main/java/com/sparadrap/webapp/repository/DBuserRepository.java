package com.sparadrap.webapp.repository;

import com.sparadrap.webapp.model.DBuser;
import org.springframework.data.repository.CrudRepository;

public interface DBuserRepository extends CrudRepository<DBuser, Long> {
    DBuser findByUsername(String username);
}
