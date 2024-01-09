package com.sparadrap.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Medecin;
import com.sparadrap.webapp.repository.MedecinRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedecinService {
	
	@Autowired 
	MedecinRepository  medecinRepository;
	
	public Medecin getMedecin(final Long id) {
		return medecinRepository.findById(id).get();
	}
	
	public Iterable<Medecin> getMedecin() {
		return medecinRepository.findAll();
	}
	
	public void deleteMedecin(final Long id) {
		medecinRepository.deleteById(id);
	}
	
	public Medecin saveMedecin(Medecin medecin) {
		Medecin savedMedecin = medecinRepository.save(medecin);
		return savedMedecin;
	}

}