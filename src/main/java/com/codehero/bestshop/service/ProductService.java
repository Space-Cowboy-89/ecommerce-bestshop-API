package com.codehero.bestshop.service;

import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.db.repository.ProductRepository;
import com.codehero.bestshop.request.ProductRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @PersistenceContext(unitName = "prodEmFactory")
    private EntityManager em;
    //Repo
    private ProductRepository productRepo;

    private final Logger LOGGER;

    public ProductService(ProductRepository productRepo, Logger LOGGER) {
        this.productRepo = productRepo;
        this.LOGGER = LoggerFactory.getLogger(ProductService.class);
    }

    public boolean addAvailProdotto(ProductRequest request){

    }

    public Product getProdByCateg(ProductRequest request){

    }



}
