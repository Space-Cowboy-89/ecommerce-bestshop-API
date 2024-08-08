package com.codehero.bestshop.db.repository;

import com.codehero.bestshop.db.entity.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, String> {

    public ProductCategory findByCategoryCode(String categoryCode);

    public List<ProductCategory> findByActive(boolean isAct);
}
