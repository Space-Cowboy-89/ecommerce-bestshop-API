package com.codehero.bestshop.db.dao.classes;

import com.codehero.bestshop.db.dao.interfaces.ProductCategoryDao;
import com.codehero.bestshop.db.entity.ProductCategory;
import com.codehero.bestshop.db.repository.ProductCategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCategoryDaoImpl implements ProductCategoryDao {
    @PersistenceContext()
    private EntityManager entityManager;

    //Repository interface
    private ProductCategoryRepository prodCatRepo;

    //Constants
    private final Logger LOGGER;

    public ProductCategoryDaoImpl(ProductCategoryRepository productCategoryRepo) {
        this.prodCatRepo = productCategoryRepo;
        this.LOGGER = LoggerFactory.getLogger(ProductCategoryDaoImpl.class);
    }


    @Override
    public ProductCategory findByCatCode(String catCode) {
        return prodCatRepo.findByCategoryCode(catCode).orElse(null);
    }

    @Override
    public List<ProductCategory> findByActTrueFalse(boolean isAct) {

        return prodCatRepo.findByActive(isAct).get();
    }

    @Override
    public List<ProductCategory> findByCatCodeList(List<String> catCodeList) {
        return prodCatRepo.findByCategoryCodeIn(catCodeList).get();
    }
}
