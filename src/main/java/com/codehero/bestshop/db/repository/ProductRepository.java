package com.codehero.bestshop.db.repository;


import com.codehero.bestshop.db.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, String> {

    @Query(value = "UPDATE product" +
            "SET price =:newPrice" +
            "WHERE SKU =:sku", nativeQuery = true)
    public void setPriceProdById(String sku, double newPrice);

    public Product findProductByName(String name);
}
