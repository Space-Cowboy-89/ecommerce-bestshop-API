package com.codehero.bestshop.db.dao.classes;

import com.codehero.bestshop.db.dao.interfaces.ProductInventoryDao;
import com.codehero.bestshop.db.entity.ProductInventory;
import com.codehero.bestshop.db.repository.ProductInventoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProductInventoryDaoImpl implements ProductInventoryDao {
    @PersistenceContext()
    private EntityManager em;

    //Repository interface
    private ProductInventoryRepository prodInvRepo;

    //Constants
    private final Logger LOGGER;


    public ProductInventoryDaoImpl(ProductInventoryRepository productInventoryRepo) {
        this.prodInvRepo = productInventoryRepo;
        this.LOGGER = LoggerFactory.getLogger(ProductInventoryDaoImpl.class);
    }

    @Override
    public List<ProductInventory> findByQuantGreaterThan(int numProducts) {
        return prodInvRepo.findByQuantityGreaterThan(numProducts).get();
    }

    @Override
    public List<ProductInventory> findBySkuProduct(List<String> skuProductList) {
        //TODO aggiustare
        return prodInvRepo.findProdInvBySkuProd(skuProductList);
    }

    @Override
    public void incDecAvaibilityProd(int newQuantity) {
        prodInvRepo.updateQuantityById( newQuantity);
    }
}

