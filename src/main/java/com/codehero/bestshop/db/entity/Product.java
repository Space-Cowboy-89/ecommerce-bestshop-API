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
    private Integer id;
    @Column
    private String name;
    @Column
    private String brand;
    @Column(name = "SKU")
    private String sku;
    @Column
    private Double price;

    //TODO relazioni
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;

    @Column(name="created_at")
    private Timestamp createdAt;
    @Column(name="modified_at")
    private Timestamp modifiedAt;
    @Column(name="deleted_at")
    private Timestamp deletedAt;


}
