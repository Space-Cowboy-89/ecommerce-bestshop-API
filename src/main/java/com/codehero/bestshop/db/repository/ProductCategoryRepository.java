package com.codehero.bestshop.db.repository;

import com.codehero.bestshop.db.entity.ProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, String> {

    public Optional<ProductCategory> findByCategoryCode(String categoryCode);

    public Optional<List<ProductCategory>> findByActive(boolean isAct);

    public Optional<List<ProductCategory>> findByCategoryCodeIn(List<String> catCodeList);
}
