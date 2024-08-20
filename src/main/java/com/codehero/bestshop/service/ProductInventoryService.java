package com.codehero.bestshop.service;


import com.codehero.bestshop.db.dao.classes.ProductInventoryDaoImpl;
import com.codehero.bestshop.db.entity.ProductInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInventoryService {
    private ProductInventoryDaoImpl prodInventDao;
    //Constants
    private Logger LOGGER;

    public ProductInventoryService(ProductInventoryDaoImpl prodInventDao, Logger LOGGER) {
        this.prodInventDao = prodInventDao;
        this.LOGGER =  LoggerFactory.getLogger(ProductInventoryService.class);
    }

    public List<ProductInventory> findByQuantityGreaterThan(int numProducts){
        return prodInventDao.findByQuantGreaterThan(numProducts);
    }

    public List<ProductInventory> findBySkuProduct(List<String> skuList){
        return prodInventDao.findBySkuProduct(skuList);
    }

    public void incrDescAvaibProd(int newQuantity){
        prodInventDao.incDecAvaibilityProd(newQuantity);
    }

}
