package com.sparadrap.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Adresse;
import com.sparadrap.webapp.repository.AdresseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdresseService {
	
	@Autowired 
	AdresseRepository  adresseRepository;
	
	public Adresse getAdresse(final long id) {
		return adresseRepository.findById(id).get();
	}
	
	public Iterable<Adresse> getAdresse() {
		return adresseRepository.findAll();
	}
	
	public void deleteAdresse(final Long id) {
		adresseRepository.deleteById(id);
	}
	
	public Adresse saveAdresse(Adresse adresse) {
		Adresse savedAdresse = adresseRepository.save(adresse);
		return savedAdresse;
	}

}