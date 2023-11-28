package com.sparadrap.webapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Client;
import com.sparadrap.webapp.repository.ClientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClientService {
	
	@Autowired 
	ClientRepository  clientRepository;
	
	public Client getClient(final Long id) {
		return clientRepository.findById(id).get();
	}
	
	public Iterable<Client> getClient() {
		return clientRepository.findAll();
	}
	
	public void deleteClient(final Long id) {
		clientRepository.deleteById(id);
	}
	
	public Client saveClient(Client client) {
		Client savedClient = clientRepository.save(client);
		return savedClient;
	}

}