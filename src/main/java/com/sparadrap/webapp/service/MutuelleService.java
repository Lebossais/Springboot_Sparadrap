package com.sparadrap.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Mutuelle;
import com.sparadrap.webapp.repository.MutuelleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MutuelleService {
	
	@Autowired 
	MutuelleRepository  mutuelleRepository;
	
	public Optional<Mutuelle> getMutuelle(final Long id) {
		return mutuelleRepository.findById(id);
	}
	
	public Iterable<Mutuelle> getMutuelle() {
		return mutuelleRepository.findAll();
	}
	
	public void deleteMutuelle(final Long id) {
		mutuelleRepository.deleteById(id);
	}
	
	public Mutuelle saveMutuelle(Mutuelle mutuelle) {
		Mutuelle savedMutuelle = mutuelleRepository.save(mutuelle);
		return savedMutuelle;
	}

}
