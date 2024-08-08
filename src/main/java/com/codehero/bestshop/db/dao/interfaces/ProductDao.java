package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.Product;

import java.util.List;
import java.util.Map;


//TODO creare "- prodotti disponibili per prodotto generico(es. "televisione 40 pollici nella barra ricerca")"
//TODO CI/CD
// creazione javadoc : javadoc -d ~/doc -sourcepath src/main/java -subpackages com.codehero.bestshop.db.dao.interfaces

public interface ProductDao {

    /**
     * Metodo che fà inserimento
     *
     * @param request
     */
    public void insertProduct(Product product);

    public Product getProdByName(String nameProduct);

    public List<Product> getProdByCategory(String categoryCode);

    // Restituisce i prodotti che hanno uno sconto attivato e disattivato
    public List<Product> getProdOfCatInDiscount(String categoryCode);

    public List<Product> getProdOfADiscount(String discountCode);

    public List<Product> getAvaibProd();

    //Restituisce i prodotti delle categorie att. o dis.
    public List<Product> getProdByCatActDis(boolean isActive);

    //Restituisce i prodotti di una categoria con uno sconto att. o dis.
    public List<Product> getProdOfCatInDiscActDis(String categoryCode, boolean isActive);

    //Restituisce prodotti disponibile che hanno uno sconto attivato e disattivato
    public List<Product> getAvaibProdInDisc();

    //Restituisce prodotti disponibile che hanno un legame con sconto dis. o att.
    public List<Product> getAvaibProdInDiscActOrDis(boolean isActive);

    public void setCatInProd(Map <String,String> mapValues);

    public void setDiscountInProd(Map <String,String> mapValues);

    public void deleteProd(List<String> skuProductList);

    public void modifyPriceProd(Map<String,Double> mapValues);
}




