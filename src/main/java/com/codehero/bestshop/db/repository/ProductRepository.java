package com.codehero.bestshop.db.repository;


import com.codehero.bestshop.db.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product, String> {

    @Query(value = "UPDATE product" +
            "SET price =:newPrice" +
            "WHERE SKU =:sku", nativeQuery = true)
    public void setPriceProdById(String sku, double newPrice);

    @Query(value =
            "select p.* " +
                    " from product p " +
                    " inner join p.productCategory c" +
                    " ON  p.productCategory = c.categoryCode" +
                    " AND c.name =:categoryName",
            nativeQuery = true)
    public List<Product> findProductByCategoryName(String categoryName);

    public Product findProductByName(String name);
}
