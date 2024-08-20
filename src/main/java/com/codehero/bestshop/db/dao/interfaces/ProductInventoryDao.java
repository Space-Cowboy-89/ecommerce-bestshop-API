package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.ProductInventory;

import java.util.List;
import java.util.Map;

public interface ProductInventoryDao {
    public List<ProductInventory> findByQuantGreaterThan(int numProducts);
    public List<ProductInventory> findBySkuProduct(List<String> skuProductList);
    public void incDecAvaibilityProd(int newQuantity);
}
