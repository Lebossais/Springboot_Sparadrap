package com.sparadrap.webapp.service;

import com.sparadrap.webapp.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Panier;
import com.sparadrap.webapp.repository.PanierRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PanierService {


    @Autowired
    PanierRepository panierRepository;

    public Panier getPanier(final Long id) {
        return panierRepository.findById(id).get();
    }

    public Iterable<Panier> getPanier() {
        return panierRepository.findAll();
    }

    public void deletePanier(final Long id) {
        panierRepository.deleteById(id);
    }

    public Panier savePanier(Panier panier) {
        Panier savedPanier = panierRepository.save(panier);
        return savedPanier;
    }

}
