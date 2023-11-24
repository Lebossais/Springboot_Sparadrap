package com.sparadrap.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Categorie;
import com.sparadrap.webapp.repository.CategorieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategorieService {
	
	@Autowired 
	CategorieRepository  categorieRepository;
	
	public Optional<Categorie> getCategorie(final Long id) {
		return categorieRepository.findById(id);
	}
	
	public Iterable<Categorie> getCategorie() {
		return categorieRepository.findAll();
	}
	
	public void deleteCategorie(final Long id) {
		categorieRepository.deleteById(id);
	}
	
	public Categorie saveCategorie(Categorie categorie) {
		Categorie savedCategorie = categorieRepository.save(categorie);
		return savedCategorie;
	}

}