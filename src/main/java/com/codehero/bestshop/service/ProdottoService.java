package com.codehero.bestshop.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ProdottoService {
    @PersistenceContext()
    private EntityManager em;
    private Logger LOGGER;

    public ProdottoService(Logger LOGGER) {
        this.LOGGER = LOGGER;
    }

    public boolean addAvailProdotto(ProdottoRequest request){}

}
