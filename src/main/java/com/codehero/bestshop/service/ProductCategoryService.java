package com.codehero.bestshop.service;


import com.codehero.bestshop.db.dao.classes.ProductCategoryDaoImpl;
import com.codehero.bestshop.db.entity.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    private ProductCategoryDaoImpl prodCatDao;
    //Constants
    private final Logger LOGGER;

    public ProductCategoryService(ProductCategoryDaoImpl prodCatDao) {
        this.prodCatDao = prodCatDao;
        LOGGER = LoggerFactory.getLogger(ProductCategoryService.class);
    }



    public ProductCategory findByCategoryCode(String categoryCode){
        return prodCatDao.findByCatCode(categoryCode);
    }

    public List<ProductCategory> findByIsAct(boolean isAct){
        return prodCatDao.findByActTrueFalse(isAct);
    }

    public List<ProductCategory> findByCategoryCodeList(List<String> catCodeList){
        return prodCatDao.findByCatCodeList(catCodeList);
    }


}
