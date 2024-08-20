package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.request.ProductRequest;
import com.codehero.bestshop.utility.Constant.DbCrudConst;

import java.util.List;
import java.util.Map;


//TODO creare "- prodotti disponibili per prodotto generico(es. "televisione 40 pollici nella barra ricerca")"
//TODO CI/CD
// creazione javadoc : javadoc -d ~/doc -sourcepath src/main/java -subpackages com.codehero.bestshop.db.dao.interfaces

public interface ProductDao {

    public void insertProduct(Product product);

    public void deleteProduct(Product product);

    public void updateProduct(Product product);

    /**
     * Method does insert, update or delete query in batch way in product table
     *
     * @param productList
     * @param dbOperation
     */
    public void dbCrudInBatch(List<Product> productList, DbCrudConst.DBOPERATION dbOperation);

    public List<Product> findBySkuList(List<String> skuList);

    public Product getProdByName(String nameProduct);

    public List<Product> getProdByCategory(String categoryCode);

    /**
     * Method retrieves products that They have active and disactive discount
     *
     * @param categoryCode
     * @return
     */
    public List<Product> getProdOfCatInDiscount(String categoryCode);

    public List<Product> getProdOfADiscount(String discountCode);

    public List<Product> getAvaibProdByCategory(String categoryCode);

    /**
     * Method retrieves product that They have active or disactive categories
     *
     * @param isActive
     * @return
     */
    public List<Product> getProdByCatActDis(boolean isActive);


    /**
     * Method retrieves products of a category that They have active or disactive discount
     *
     * @param categoryCode
     * @param isActive
     * @return
     */
    public List<Product> getProdOfCatInDiscActDis(String categoryCode, boolean isActive);


     /**
     * Method retrieves available product that They have active and disactive discount
     *
     * @return
     */
    public List<Product> getAvaibProdInDisc();

    /**
     * Method retrievs available products that They have relation with active or disactive discount
     *
     * @param isActive
     * @return
     */
    public List<Product> getAvaibProdInDiscActOrDis(boolean isActive);
}




