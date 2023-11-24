package com.sparadrap.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Entreprise;
import com.sparadrap.webapp.repository.EntrepriseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EntrepriseService {

	@Autowired 
	EntrepriseRepository  entrepriseRepository;
	
	public Optional<Entreprise> getEntreprise(final Long id) {
		return entrepriseRepository.findById(id);
	}
	
	public Iterable<Entreprise> getEntreprise() {
		return entrepriseRepository.findAll();
	}
	
	public void deleteEntreprise(final Long id) {
		entrepriseRepository.deleteById(id);
	}
	
	public Entreprise saveEntreprise(Entreprise entreprise) {
		Entreprise savedEntreprise = entrepriseRepository.save(entreprise);
		return savedEntreprise;
	}

}