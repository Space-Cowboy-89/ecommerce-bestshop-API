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
    private ProductInventoryRepository prodInvRepo;
    private final Logger LOGGER;


    public ProductInventoryDaoImpl(ProductInventoryRepository productInventoryRepo) {
        this.prodInvRepo = productInventoryRepo;
        this.LOGGER = LoggerFactory.getLogger(ProductInventoryDaoImpl.class);
    }

    @Override
    public List<ProductInventory> findByQuantGreaterThan(int numProducts) {
        return prodInvRepo.findByQuantityGreaterThan(numProducts);
    }

    @Override
    public List<ProductInventory> findBySkuProduct(List<String> skuProductList) {
        return prodInvRepo.findProdInvBySkuProd(skuProductList);
    }

    /**
     * Le chiavi della Map contiene gli SKU di Product.
     * I valori della stessa contiene la quantità dei prodotti da incrementare.
     *
     * @param prodAndQuant
     */
    //TODO aggiustare
    @Override
    public void incDecAvaibilityProd(Map<String, Integer> prodAndQuant) {
        List<ProductInventory> prodInvList = findBySkuProduct(new ArrayList<>
                (prodAndQuant.keySet()));

        for (ProductInventory pInventory : prodInvList)
            for (Integer valueQuant : prodAndQuant.values())
                prodInvRepo.updateQuantityById(valueQuant, pInventory.getId());
    }
}

