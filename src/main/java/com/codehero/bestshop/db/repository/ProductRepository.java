package com.codehero.bestshop.db.repository;


import com.codehero.bestshop.db.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends CrudRepository<Product, String> {


    public Optional<Integer> updatePriceBySku(double price, String sku);

    public Optional<List<Product>> findBySkuIn(List<String> sku);

    public Optional<Product> findByName(String name);

    @Query(value =
            "select p.* " +
                    " from product p " +
                    " inner join p.productCategory c" +
                    " ON  p.productCategory = c.categoryCode" +
                    " AND c.name =:categoryName",
            nativeQuery = true)
    public List<Product> findProductByCategoryName(String categoryName);


    @Query(value =
            "select p.*" +
                    " from product_category pc" +
                    " inner join product p" +
                    " on p.category_id = pc.id" +
                    " inner join discount d" +
                    " on p.discount_id = d.id" +
                    " where d.active =:isActive" +
                    " and pc.category_code =:categoryCode",
            nativeQuery = true)
    public List<Product> findProdByCatCodeAndDiscIsAct(String categoryCode, boolean isActive);

    @Query(value =
            "select p.*" +
                    " from discount d" +
                    " inner join product p" +
                    " on p.discount_id = d.id" +
                    " inner join product_inventory" +
                    " on p.inventory_id = d.id" +
                    " where i.quantity > 0",
            nativeQuery = true)
    public List<Product> findAvaibProdInDisc();


    @Query(value =
            "select p.*" +
                    " from discount d" +
                    " inner join product p" +
                    " on p.discount_id = d.id" +
                    " inner join product_inventory" +
                    " on p.inventory_id = d.id" +
                    " where i.quantity > 0" +
                    " and d.active =:isActive",
            nativeQuery = true)
    public List<Product> findAvaibProdByDiscIsActDis(boolean isActive);
}
