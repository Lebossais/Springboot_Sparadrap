package com.sparadrap.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Medicament;
import com.sparadrap.webapp.repository.MedicamentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicamentService {
	
	@Autowired 
	MedicamentRepository  medicamentRepository;
	
	public Medicament getMedicament(final Long id) {
		return medicamentRepository.findById(id).get();
	}
	
	public Iterable<Medicament> getMedicament() {
		return medicamentRepository.findAll();
	}
	
	public void deleteMedicament(final Long id) {
		medicamentRepository.deleteById(id);
	}
	
	public Medicament saveMedicament(Medicament medicament) {
		Medicament savedMedicament = medicamentRepository.save(medicament);
		return savedMedicament;
	}
}
