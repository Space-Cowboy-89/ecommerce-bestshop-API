package com.codehero.bestshop.service;

import com.codehero.bestshop.db.dao.classes.ProductDaoImpl;
import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.db.entity.ProductInventory;
import com.codehero.bestshop.request.ProductRequest;
import com.codehero.bestshop.utility.Constant.DbCrudConst;
import com.codehero.bestshop.utility.Constant.GeneralConst;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//TODO integrare :
//- lettura/scrittura in un file
//- Stream
//- Optional
@Service
public class ProductService {
    // Dao Class
    private ProductDaoImpl productDao;
    //Services
    private ProductCategoryService prodCatSrv;
    private DiscountService discountSrv;
    //Constants
    private final Logger LOGGER;

    public ProductService(ProductDaoImpl productDao, ProductCategoryService prodCatSrv, DiscountService discountSrv) {
        this.productDao = productDao;
        this.prodCatSrv = prodCatSrv;
        this.discountSrv = discountSrv;
        this.LOGGER = LoggerFactory.getLogger(ProductService.class);
    }

    public void insertProductList(List<ProductRequest> requestList) {
        List<Product> productList = new ArrayList<>();
        for (ProductRequest request : requestList)
            productList.add(createProduct(request));

        productDao.dbCrudInBatch(productList, DbCrudConst.DBOPERATION.insert);
    }

    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setSku(productRequest.getSku());
        product.setName(productRequest.getName());
        product.setBrand(productRequest.getBrand());
        product.setPrice(productRequest.getPrice());
        product.setProductCategory(prodCatSrv.findByCategoryCode(productRequest.getCategoryCode()));
        product.setDiscount(discountSrv.findByDiscountCode(productRequest.getDiscountCode()));
        product.setProductInventory(new ProductInventory(productRequest.getQuantity()));
        product.setCartItem();
        return product;
    }

    public String deleteProductList(List<String> skuList) {
        List<Product> productList = productDao.findBySkuList(skuList);
        String message = null;
        if (skuList.size() != productList.size())
            message = check(skuList,
                    productList.stream().map(Product::getSku).toList());
        productDao.dbCrudInBatch(productList, DbCrudConst.DBOPERATION.delete);
        return message == null ? "ok" : message;
    }

    public String updateProductList(List<ProductRequest> requestList) {
        List<String> skuList = requestList.stream().map(ProductRequest::getSku).toList();
        List<Product> productList = productDao.findBySkuList(skuList);
        int prodListSize = productList.size();
        String message = null;
        if (skuList.size() != prodListSize)
            message = check(skuList,
                    productList.stream().map(Product::getSku).toList());

        for (int i = 0; i < prodListSize; ++i)
            setProdFields(productList.get(i), requestList.get(i));

        productDao.dbCrudInBatch(productList, DbCrudConst.DBOPERATION.update);
        return message == null ? "ok" : message;
    }

    public String check(List<String> skuRequestList, List<String> skuProductList) {
        String str = "";
        for (String skuRequest : skuRequestList) {
            boolean flag = true;
            for (String skuProduct : skuProductList)
                if (skuProduct.equals(skuRequest)) {
                    flag = false;
                    break;
                }

            if (flag)
                str += skuRequest + ", ";
        }

        return "I record con sku = " + str + " non sono presenti nel db!";
    }

    /**
     * @param product
     * @param request
     */
    public Product setProdFields(Product product, ProductRequest request) {
        String stringVal;
        double doubleVal;
        int intVal;

        if ((intVal = request.getId()) != GeneralConst.NOINTEGERVAL)
            product.setId(intVal);
        if (!(stringVal = request.getName()).equals(GeneralConst.NOSTRINGVAL))
            product.setName(stringVal);
        if (!(stringVal = request.getBrand()).equals(GeneralConst.NOSTRINGVAL))
            product.setBrand(stringVal);
        if (!(stringVal = request.getSku()).equals(GeneralConst.NOSTRINGVAL))
            product.setSku(stringVal);
        if (!(stringVal = request.getDesc()).equals(GeneralConst.NOSTRINGVAL))
            product.setDesc(stringVal);
        if ((doubleVal = request.getPrice()) != GeneralConst.NODOUBLEVAL)
            product.setPrice(doubleVal);
        if ((intVal = request.getQuantity()) != GeneralConst.NOINTEGERVAL)
            product.setProdInventoryQuantity(intVal);
        if (!(stringVal = request.getCategoryCode()).equals(GeneralConst.NOSTRINGVAL))
            product.setProductCategory(prodCatSrv.findByCategoryCode(stringVal));
        if (!(stringVal = request.getDiscountCode()).equals(GeneralConst.NOSTRINGVAL))
            product.setDiscount(discountSrv.findByDiscountCode(stringVal));
        return product;
    }

    public void insertProduct(ProductRequest request) {
        productDao.insertProduct(createProduct(request));
        LOGGER.info("Inserimento ok");
    }

    public void updateProduct(ProductRequest request) {
        productDao.updateProduct(setProdFields(productDao.getBySku(request.getSku()), request));
    }

    public void deleteProduct(ProductRequest request) {
        productDao.deleteProduct(productDao.getBySku(request.getSku()));
    }

    public Product getProductByName(String name) {
        return productDao.getProdByName(name);
    }

    public List<Product> getBySkuList(List<String> skuList) {
        return productDao.findBySkuList(skuList);
    }

    public List<Product> getProductByCat(String categoryCode) {
        return productDao.getProdByCategory(categoryCode);
    }

    public List<Product> getProdOfCatInDiscount(String categoryCode, String discountCode) {
        return productDao.getProdOfCatInDiscount(categoryCode, discountCode);
    }

    public List<Product> getProductOfADisc(String discountCode) {
        return productDao.getProdOfADiscount(discountCode);
    }

    public List<Product> getAvailableProdByCategory(String categoryCode) {
        return productDao.getAvaibProdByCategory(categoryCode);
    }

    public List<Product> getProdOfCatActDis(boolean isActive) {
        return productDao.getProdByCatActDis(isActive);
    }

    public List<Product> getProdOfACatInDiscountActDis(String categoryCode, boolean isActive) {
        return productDao.getProdOfCatInDiscActDis(categoryCode, isActive);
    }

    public List<Product> getAvaibProdInDiscount() {
        return productDao.getAvaibProdInDisc();
    }

    public List<Product> getAvaibProdInDiscountActOrDis(boolean isActive) {
        return productDao.getAvaibProdInDiscActOrDis(isActive);
    }
}
