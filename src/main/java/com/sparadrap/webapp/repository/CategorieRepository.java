package com.sparadrap.webapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrap.webapp.model.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long>{

}
