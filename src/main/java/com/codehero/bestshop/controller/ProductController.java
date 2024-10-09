package com.codehero.bestshop.controller;

import com.codehero.bestshop.db.entity.Product;
import com.codehero.bestshop.request.ProductRequest;
import com.codehero.bestshop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO gestione controllo se size lista di request e diverso da quella dei record
//TODo vedere ResponseEntity

@RestController
@RequestMapping("/ProductRestController")
public class ProductController {
    private ProductService productSrv;

    private final Logger LOGGER;

    public ProductController(ProductService productSrv) {
        this.productSrv = productSrv;
        this.LOGGER = LoggerFactory.getLogger(ProductController.class);
    }

    @PostMapping(
            path = "/insertProductList",
            consumes = "application/json",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> insertProductList(@RequestBody List<ProductRequest> prodRequestList) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("header", "Insert product record.");
        productSrv.insertProductList(prodRequestList);
        return new ResponseEntity<String>("ok",
                httpHeaders
                , HttpStatus.OK);
    }

    @PostMapping(
            path = "/deleteProductList",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteProductList(@RequestParam List<String> skuList) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Header", "delete product record.");
        return new ResponseEntity<String>(productSrv.deleteProductList(skuList),
                httpHeaders,
                HttpStatus.OK);

    }




    @PostMapping(
            path = "/updateProductList",
            consumes = "application/json",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> updateProductList(@RequestBody List<ProductRequest> productRequestList) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Header", "Update product record.");
        return new ResponseEntity<String>(
                productSrv.updateProductList(productRequestList),
                httpHeaders,
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/getProductsBySkuList",
            consumes = "application/json"
    )
    public ResponseEntity<List<Product>> getProdBySkuList(@PathVariable List<String> skuList){
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Header","Return Products by list of SKU!");
        return new ResponseEntity(productSrv.getBySkuList(skuList),httpHeaders,HttpStatus.OK);
    }


    @GetMapping(
            path = "/getProductsByCategory",
            consumes = "application/json"
    )
    public ResponseEntity<List<Product>> getProductByCat(String categoryCode) {
        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.add("Header","Retrieve Product by a specific Category!");
        return new ResponseEntity(productSrv.getProductByCat(categoryCode),httpHeader,HttpStatus.OK);
    }

    @GetMapping(
            path = "/getProductsByDiscount",
            consumes = "application/json"
    )
    public ResponseEntity<List<Product>> getProductByDiscount(String discountCode) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Header","Retrieve product in a specific discount!");
        return new ResponseEntity(productSrv.getProductOfADisc(discountCode),httpHeaders,HttpStatus.OK);
    }



}
