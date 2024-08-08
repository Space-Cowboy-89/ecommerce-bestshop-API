package com.codehero.bestshop.db.dao.classes;

import com.codehero.bestshop.db.dao.interfaces.ProductDao;
import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.db.entity.ProductCategory;
import com.codehero.bestshop.db.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//TODO creare interf. Dao altre Entity
@Component
public class ProductDaoImpl implements ProductDao {
    @PersistenceContext()
    private EntityManager em;
    //Repo interface
    private ProductRepository productRepo;
    //DAO classes
    private ProductInventoryDaoImpl prodInventDao;
    private ProductCategoryDaoImpl prodCatDao;
    private DiscountDaoImpl discDao;
    //Costants
    private final int BATCHSIZE = 100;
    private final Logger LOGGER;


    public ProductDaoImpl(ProductRepository productRepo, ProductInventoryDaoImpl prodInventDao, ProductCategoryDaoImpl prodCatDao, DiscountDaoImpl discDao) {
        this.productRepo = productRepo;
        this.prodInventDao = prodInventDao;
        this.prodCatDao = prodCatDao;
        this.discDao = discDao;
        this.LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);
    }

    //TODO fare service
    @Override
    public void insertProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product getProdByName(String nameProduct) {
        return productRepo.findByName(nameProduct);
    }

    // TODO fare ProductCategoryDao
    @Override
    public List<Product> getProdByCategory(String categoryCode) {
        ProductCategory productCategory = productCategoryRepo.findByCategoryCode(categoryCode);
        return productCategory.getProductList();
    }

    @Override
    public List<Product> getProdOfCatInDiscount(String categoryCode) {
        return null;
    }

    @Override
    public List<Product> getProdOfADiscount(String discountCode) {
        return null;
    }

    @Override
    public List<Product> getAvaibProd() {
        return null;
    }


    @Override
    public List<Product> getProdByCatActDis(boolean isActive) {
        List<Product> retProdList = new ArrayList<>();
        for (ProductCategory category : prodCatDao.findByActTrueFalse(isActive))
            retProdList.addAll(category.getProductList());

        return retProdList;
    }

    @Override
    public List<Product> getProdOfCatInDiscActDis(String categoryCode, boolean isActive) {
        return productRepo.findProdByCatCodeAndDiscIsAct(categoryCode, isActive);
    }

    @Override
    public List<Product> getAvaibProdInDisc() {
        return productRepo.findAvaibProdInDisc();
    }


    @Override
    public List<Product> getAvaibProdInDiscActOrDis(boolean isActive) {
        return productRepo.findAvaibProdByDiscIsActDis(isActive);
    }


    //TODO aggiustare
    @Override
    public void setCatInProd(Map<String, String> mapValues) {
        List<String> skuProdList = new ArrayList<>(mapValues.keySet());
        for (Product product : productRepo.findBySkuIn(skuProdList))
            for (String categoryCode : mapValues.values())
                product.setProductCategory(prodCatDao.findByCatCode(categoryCode));
    }

    //TODO aggiustare
    @Override
    public void setDiscountInProd(Map<String, String> mapValues) {
//        List<String> skuProdList = new ArrayList<>(mapValues.keySet());
//        for (Product product : productRepo.findBySkuIn(skuProdList))
//            for (String discountCode : mapValues.values())
//                product.setDiscount(discDao.findByDiscCode(discountCode));

        List<String> skuProdList = new ArrayList<>(mapValues.keySet());
        List<Product> productList =productRepo.findBySkuIn(skuProdList);
        List<String> discountCodeList = discDao.findByDiscCode()new ArrayList<>(mapValues.values());
        int mapSize =mapValues.size();
        for (int i =0 ; i<mapSize;i++){
            Product product = productList.get(i);
            product.setDiscount(discountCodeList.get(i));
        }

    }

    @Override
    public void deleteProd(List<String> skuProductList) {
        em.createNativeQuery(
                        "delete from product" +
                                "where id in (:skuProductList)")
                .setParameter("skuProductList", skuProductList)
                .executeUpdate();
    }

    //TODO concludere
    @Override
    public void modifyPriceProd(Map<String,Double> mapValues) {
        List<Product> productList = productRepo.findBySkuIn(new ArrayList<>(mapValues.keySet()));
        List<Double> newPriceList = new ArrayList<>(mapValues.values());
        int skuListSize = newPriceList.size();
        for(int i = 0; i< skuListSize; i++){
            Product product = productList.get(i);
            product.setPrice(newPriceList.get(i));
            em.merge(product);
            if(i%BATCHSIZE == 0 && i>0){
                em.flush();
                em.clear();
            }
       }
        em.flush();
        em.clear();
    }
}


