package com.sparadrap.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Specialiste;
import com.sparadrap.webapp.repository.SpecialisteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SpecialisteService {
	
	@Autowired 
	SpecialisteRepository  specialisteRepository;
	
	public Optional<Specialiste> getSpecialiste(final Long id) {
		return specialisteRepository.findById(id);
	}
	
	public Iterable<Specialiste> getSpecialiste() {
		return specialisteRepository.findAll();
	}
	
	public void deleteSpecialiste(final Long id) {
		specialisteRepository.deleteById(id);
	}
	
	public Specialiste saveSpecialiste(Specialiste specialiste) {
		Specialiste savedSpecialiste = specialisteRepository.save(specialiste);
		return savedSpecialiste;
	}

}