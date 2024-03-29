package com.sparadrap.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Achat;
import com.sparadrap.webapp.repository.AchatRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AchatService {
	
	@Autowired 
	AchatRepository  achatRepository;
	
	public Achat getAchat(final Long id) {
		return achatRepository.findById(id).get();
	}
	
	public Iterable<Achat> getAchat() {
		return achatRepository.findAll();
	}
	
	public void deleteAchat(final Long id) {
		achatRepository.deleteById(id);
	}
	
	public Achat saveAchat(Achat achat) {
		Achat savedAchat = achatRepository.save(achat);
		return savedAchat;
	}

}