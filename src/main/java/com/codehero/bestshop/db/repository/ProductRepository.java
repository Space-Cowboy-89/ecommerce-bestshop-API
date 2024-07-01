package com.codehero.bestshop.db.repository;


import com.codehero.bestshop.db.entity.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product,Integer> {
}
