package com.sparadrap.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Personne;
import com.sparadrap.webapp.repository.PersonneRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonneService {
	
	@Autowired 
	PersonneRepository  personneRepository;
	
	public Optional<Personne> getPersonne(final Long id) {
		return personneRepository.findById(id);
	}
	
	public Iterable<Personne> getPersonne() {
		return personneRepository.findAll();
	}
	
	public void deletePersonne(final Long id) {
		personneRepository.deleteById(id);
	}
	
	public Personne savePersonne(Personne personne) {
		Personne savedPersonne = personneRepository.save(personne);
		return savedPersonne;
	}

}