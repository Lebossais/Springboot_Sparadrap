package com.sparadrap.webapp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Adresse;
import com.sparadrap.webapp.repository.AdresseRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Service
@Transactional
public class AdresseService {
	
	@Autowired AdresseRepository  adresseRepository;
	
	public Optional<Adresse> getAdresse(final Long id) {
		return adresseRepository.findById(id);
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