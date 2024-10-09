package com.codehero.bestshop.db.dao.classes;

import com.codehero.bestshop.db.dao.interfaces.ProductDao;
import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.db.entity.ProductCategory;
import com.codehero.bestshop.db.repository.ProductRepository;
import com.codehero.bestshop.utility.Constant.DbCrudConst;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//TODO creare interf. Dao altre Entity

@Component
public class ProductDaoImpl implements ProductDao {
    @PersistenceContext()
    private EntityManager em;

    //Repository interface
    private ProductRepository productRepo;

    //DAO classes
    private ProductInventoryDaoImpl prodInventDao;
    private ProductCategoryDaoImpl prodCatDao;
    private DiscountDaoImpl discDao;
    private GeneralDaoImpl<Product> generalDao;

    //Costants
    private final Logger LOGGER;

    public ProductDaoImpl(ProductRepository productRepo, ProductInventoryDaoImpl prodInventDao
            , ProductCategoryDaoImpl prodCatDao, DiscountDaoImpl discDao, GeneralDaoImpl<Product> generalDao) {
        this.productRepo = productRepo;
        this.prodInventDao = prodInventDao;
        this.prodCatDao = prodCatDao;
        this.discDao = discDao;
        this.generalDao = generalDao;
        this.LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);
    }


    public void insertProduct(Product product) {
        productRepo.save(product);
    }

    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }

    public void dbCrudInBatch(List<Product> productList, DbCrudConst.DBOPERATION dbOperation) {
        generalDao.dbCrudInBatch(productList, dbOperation);
    }

    public Optional<Product> getBySku(String sku) {
        return productRepo.findBySku(sku);
    }

    @Override
    public Optional<Product> getProdByName(String nameProduct) {
        return productRepo.findByName(nameProduct);
    }

    @Override
    public Optional<List<Product>> findBySkuList(List<String> skuList) {

        return productRepo.findBySkuIn(skuList);
    }


    @Override
    public List<Product> getProdByCategory(String categoryCode) {
        ProductCategory prodCat = prodCatDao.findByCatCode(categoryCode);
        if (prodCat == null)
            return null;
        return prodCat.getProductList();
    }

    @Override
    public List<Product> getProdOfCatInDiscount(String categoryCode, String discountCode) {
        return productRepo.findProdByCatCodAndDiscCode(categoryCode, discountCode);
    }

    @Override
    public List<Product> getProdOfADiscount(String discountCode) {
        return discDao.findByDiscCode(discountCode).getProductList();
    }

    @Override
    public List<Product> getAvaibProdByCategory(String categoryCode) {
        List<Product> retProductList = new ArrayList<>();
        for (Product product : prodCatDao.findByCatCode(categoryCode).getProductList())
            if (product.getProductInventory().getQuantity() > 0)
                retProductList.add(product);

        return retProductList;
    }


    @Override
    public List<Product> getProdByCatActDis(boolean isActive) {
//        todo continuare da qui
        List<Product> retProdList = new ArrayList<>();
        for (ProductCategory category : prodCatDao.findByActTrueFalse(isActive).get())
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


}


