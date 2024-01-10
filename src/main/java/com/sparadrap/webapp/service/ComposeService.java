package com.sparadrap.webapp.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparadrap.webapp.model.Compose;
import com.sparadrap.webapp.repository.ComposeRepository;

@Service
@Transactional
public class ComposeService {

    @Autowired
    ComposeRepository composeRepository;

    public Compose getCompose(final Long id) {
        return composeRepository.findById(id).get();
    }

    public Iterable<Compose> getClient() {
        return composeRepository.findAll();
    }

    public void deleteCompose(final Long id) {
        composeRepository.deleteById(id);
    }

    public Compose saveCompose(Compose compose) {
        Compose savedCompose = composeRepository.save(compose);
        return savedCompose;
    }

}
