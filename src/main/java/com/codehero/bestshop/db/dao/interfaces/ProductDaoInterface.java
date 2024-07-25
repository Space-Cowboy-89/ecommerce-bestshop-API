package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.request.ProductRequest;

import java.util.List;


//TODO Inserire oggetti request nei metodi
//TODO creare "- prodotti disponibili per prodotto generico(es. "televisione 40 pollici nella barra ricerca")"
public interface ProductDaoInterface {

    public void insertProduct(ProductRequest request);

    public Product getProdByName(String name);

    public List<Product> getProdByCategory(String categoryCode);

    public List<Product> getProdOfCatInDiscount(String categoryCode);

    public List<Product> getProdOfADiscount(String discountCode);

    public List<Product> getAvaibProd();

    //Restituisce i prodotti di una categoria att./dis.
    public List<Product> getProdOfCatActDis();

    //Restituisce i prodotti di una categoria con uno sconto att./dis.
    public List<Product> getProdOfCatInDiscActDis();

    //Restituisce prodotti disponibile che hanno un legame con sconto
    public List<Product> getAvaibProdInDisc();

    //Restituisce prodotti disponibile che hanno un legame con sconto dis./att.
    public List<Product> getAvaibProdInDiscActOrDis();

    public void increaseAvaibilityProd(String sku);

    public void decreaseAvaibilityProd(String sku);

    public void setCatInProd(String categoryCod);

    public void setDiscountInProd(String discountCode);

    public void removeProd(String sku);

    public void modifyPriceProd(String sku, double newPrice);
}
