package com.sparadrap.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Ordonnance;
import com.sparadrap.webapp.repository.OrdonnanceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrdonnanceService {
	
	@Autowired 
	OrdonnanceRepository  ordonnanceRepository;
	
	public Optional<Ordonnance> getOrdonnance(final Long id) {
		return ordonnanceRepository.findById(id);
	}
	
	public Iterable<Ordonnance> getOrdonnance() {
		return ordonnanceRepository.findAll();
	}
	
	public void deleteOrdonnance(final Long id) {
		ordonnanceRepository.deleteById(id);
	}
	
	public Ordonnance saveOrdonnance(Ordonnance ordonnance) {
		Ordonnance savedOrdonnance = ordonnanceRepository.save(ordonnance);
		return savedOrdonnance;
	}

}