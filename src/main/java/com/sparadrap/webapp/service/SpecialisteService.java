package com.sparadrap.webapp.service;

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
	
	public Specialiste getSpecialiste(final Long id) {
		return specialisteRepository.findById(id).get();
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