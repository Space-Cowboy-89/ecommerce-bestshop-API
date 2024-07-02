package com.codehero.bestshop.db.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;
import java.util.List;

@Entity
@DynamicInsert
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "discount_code")
    private String discountCode;
    @Column(nullable = false)
    private String name;
    @Column
    private String desc;
    @Column(name = "discount_percent")
    private Double discountPercent;
    @Column(nullable = false)
    private Boolean active;
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @Column(name = "modified_at")
    private Timestamp modifiedAt;
    @Column(name = "deleted_at")
    private Timestamp deletedAt;
    @OneToMany(mappedBy = "discount")
    private List<Product> productList;

    public Discount() {
    }

    public Discount(String discountCode,String name, String desc, Double discountPercent, Boolean active, Timestamp createdAt, Timestamp modifiedAt, Timestamp deletedAt, List<Product> productList) {
        this.discountCode = discountCode;
        this.name = name;
        this.desc = desc;
        this.discountPercent = discountPercent;
        this.active = active;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
        this.productList = productList;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }

    public String getDesc() {
        return desc;
    }

    public Double getDiscountPercent() {
        return discountPercent;
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

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
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

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
