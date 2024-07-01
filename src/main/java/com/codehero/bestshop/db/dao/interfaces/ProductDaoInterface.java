package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.Product;

import java.util.List;

public interface ProductDaoInterface {
    public Product getProdByName(String name);
    public List<Product> retProdListByCategory(String categoryCode);
    public List<Product> retAvaibProdOfCatInDiscount(String categoryCode);
    public void insertProd(Product product);
    public List<Product> retProdInDiscount();
    public void increaseAvaibilityProd(String sku);
    public void decreaseAvaibilityProd(String sku);
    public void removeProd(String sku);
    public void modifyPriceProd(String sku, double newPrice);
    public void addDiscountToAProd(double percentDisc);

    //TODO creare "- prodotti disponibili per prodotto generico(es. "televisione 40 pollici nella barra ricerca")"
}
