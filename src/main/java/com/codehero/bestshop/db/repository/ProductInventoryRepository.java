package com.codehero.bestshop.db.repository;

import com.codehero.bestshop.db.entity.ProductInventory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductInventoryRepository extends CrudRepository<ProductInventory,Integer> {

    @Query(value =
            " select i.id" +
            " from product_inventory i" +
            " inner join product p" +
            " on i.id = p.inventory_id" +
            " where p.SKU in (:skuProductList)"
    ,nativeQuery = true)
    public List<ProductInventory> findProdInvBySkuProd(List<String> skuProductList);

    @Transactional
    @Modifying
    public int updateQuantityById(Integer quantity, Integer id);

    public List<ProductInventory> findByQuantityGreaterThan (int numProduct);
}
