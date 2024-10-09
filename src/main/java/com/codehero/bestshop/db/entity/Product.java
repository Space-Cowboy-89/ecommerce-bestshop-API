package com.codehero.bestshop.db.entity;


import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Fetch;

import java.sql.Timestamp;

@Entity
@Table(name = "product")
@DynamicInsert
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "SKU")
    private String sku;
    @Column
    private String name;
    @Column
    private String brand;
    @Getter
    @Column
    private String desc;
    @Column
    private Double price;
    @Column(name="created_at")
    private Timestamp createdAt;
    @Column(name="modified_at")
    private Timestamp modifiedAt;
    @Column(name="deleted_at")
    private Timestamp deletedAt;


    //relazioni
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventory_id")
    private ProductInventory productInventory;
    @OneToOne(mappedBy = "product",fetch = FetchType.EAGER)
    private CartItem cartItem;


    public Product() {}

    public Product(Integer id) {
        this.id = id;
    }

    public Product(String sku, String name, String brand, Double price, Timestamp createdAt, Timestamp modifiedAt,
                   Timestamp deletedAt, ProductCategory productCategory, Discount discount, ProductInventory productInventory, CartItem cartItem) {
        this.sku = sku;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
        this.productCategory = productCategory;
        this.discount = discount;
        this.productInventory = productInventory;
        this.cartItem = cartItem;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Double getPrice() {
        return price;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public Discount getDiscount() {
        return discount;
    }

    public ProductInventory getProductInventory() {
        return productInventory;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setProductInventory(ProductInventory productInventory) {
        this.productInventory = productInventory;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setProdInventoryQuantity(int newQuantity){
        productInventory.setQuantity(newQuantity);
    }

}
