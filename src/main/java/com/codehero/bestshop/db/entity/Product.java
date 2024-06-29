package com.codehero.bestshop.db.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Fetch;

import java.sql.Timestamp;

@Entity
@Table(name = "product")
@DynamicInsert
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String brand;
    @Column(name = "SKU")
    private String sku;
    @Column
    private Double price;
    @Column(name="created_at")
    private Timestamp createdAt;
    @Column(name="modified_at")
    private Timestamp modifiedAt;
    @Column(name="deleted_at")
    private Timestamp deletedAt;


    //relazioni
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @OneToOne
    @JoinColumn(name = "inventory_id")
    private ProductInventory productInventory;
    @OneToOne(mappedBy = "product")
    private CartItem cartItem;


    public Product() {}

}
