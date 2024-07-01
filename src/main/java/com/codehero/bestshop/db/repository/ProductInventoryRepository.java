package com.codehero.bestshop.db.repository;

import com.codehero.bestshop.db.entity.ProductInventory;
import org.springframework.data.repository.CrudRepository;

public interface ProductInventoryRepository extends CrudRepository<ProductInventory,Integer> {
}
