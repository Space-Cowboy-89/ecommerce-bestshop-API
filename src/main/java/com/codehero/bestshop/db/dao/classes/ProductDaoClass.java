package com.codehero.bestshop.db.dao.classes;

import com.codehero.bestshop.db.dao.interfaces.ProductDaoInterface;
import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.db.repository.DiscountRepository;
import com.codehero.bestshop.db.repository.ProductCategoryRepository;
import com.codehero.bestshop.db.repository.ProductInventoryRepository;
import com.codehero.bestshop.db.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductDaoClass implements ProductDaoInterface {
    @PersistenceContext()
    private EntityManager em;
    private final Logger LOGGER;
    // interf. repo
    private final ProductRepository productRepo;
    private final ProductCategoryRepository productCategoryRepo;
    private final ProductInventoryRepository productInventoryRepo;
    private final DiscountRepository discountRepo;

    public ProductDaoClass(Logger LOGGER, ProductRepository productRepo, ProductCategoryRepository productCategoryRepo, ProductInventoryRepository productInventoryRepo, DiscountRepository discountRepo) {
        this.productRepo = productRepo;
        this.productCategoryRepo = productCategoryRepo;
        this.productInventoryRepo = productInventoryRepo;
        this.discountRepo = discountRepo;
        this.LOGGER = LoggerFactory.getLogger(ProductDaoClass.class);
    }

    @Override
    public Product getProdByName(String name) {
        return null;
    }

    @Override
    public List<Product> retProdListByCategory(String categoryCode) {
        return null;
    }

    @Override
    public List<Product> retAvaibProdOfCatInDiscount(String categoryCode) {
        return null;
    }

    @Override
    public void insertProd(Product product) {

    }

    @Override
    public List<Product> retProdInDiscount() {
        return null;
    }

    @Override
    public void increaseAvaibilityProd(String sku) {

    }

    @Override
    public void decreaseAvaibilityProd(String sku) {

    }

    @Override
    public void addDiscountToAProd(double percentDisc) {

    }

    @Override
    public void removeProd(String sku) {

    }

    @Override
    public void modifyPriceProd(String sku, double newPrice) {

    }
}
