package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryDao {

    public Optional<List<ProductCategory>> findByActTrueFalse(boolean isAct);

    public ProductCategory findByCatCode(String catCode);

    public List<ProductCategory> findByCatCodeList(List<String> catCodeList);
}
