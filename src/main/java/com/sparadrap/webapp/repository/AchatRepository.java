package com.sparadrap.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Achat;

@Repository
public interface AchatRepository extends CrudRepository<Achat, Long> {

//@Query("SELECT AchatID from Achat order by AchatID DESC LIMIT 1")
//    Achat findLastAchatID();

    Achat findTopByOrderByAchatidDesc();

}
