package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.request.ProductRequest;

import java.util.List;


//TODO Inserire oggetti request nei metodi
//TODO creare "- prodotti disponibili per prodotto generico(es. "televisione 40 pollici nella barra ricerca")"
//TODO CI/CD

// creazione javadoc : javadoc -d ~/doc -sourcepath src/main/java -subpackages com.codehero.bestshop.db.dao.interfaces

public interface ProductDaoInterface {

    /**
     * Metodo che fà inserimento
     *
     * @param request
     */
    public void insertProduct(List<ProductRequest> request);

    public Product getProdByName(String name);

    public List<Product> getProdByCategory(String categoryCode);

    // Restituisce i prodotti che hanno uno sconto attivato e disattivato
    public List<Product> getProdOfCatInDiscount(String categoryCode);

    public List<Product> getProdOfADiscount(String discountCode);

    public List<Product> getAvaibProd();

    //Restituisce i prodotti di una categoria att. o dis.
    public List<Product> getProdOfCatActDis(String categoryCode);

    //Restituisce i prodotti di una categoria con uno sconto att. o dis.
    public List<Product> getProdOfCatInDiscActDis(String categoryCode);

    //Restituisce prodotti disponibile che hanno uno sconto attivato e disattivato
    public List<Product> getAvaibProdInDisc();

    //Restituisce prodotti disponibile che hanno un legame con sconto dis. o att.
    public List<Product> getAvaibProdInDiscActOrDis();

    public void increaseAvaibilityProd(List<ProductRequest> requestList);

    public void decreaseAvaibilityProd(List<ProductRequest> requestList);

    public void setCatInProd(List<ProductRequest> requestList,String categoryCod);

    public void setDiscountInProd(List<ProductRequest> requestList,String discountCode);

    public void removeProd(List<ProductRequest> requestList,String sku);

    public void modifyPriceProd(List<ProductRequest> requestList,String sku, double newPrice);
}
