package com.codehero.bestshop.db.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;


@Entity
@DynamicInsert
@Table(name = "product_category")
public class ProductCategory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column
    private String desc;
    @Column(name="created_at", nullable = false)
    private Timestamp createdAt;
    @Column(name="modified_at")
    private Timestamp modifiedAt;
    @Column(name="deleted_at")
    private Timestamp deletedAt;

    public ProductCategory() {
    }

    public ProductCategory(Integer id, String name, String desc, Timestamp createdAt, Timestamp modifiedAt, Timestamp deletedAt) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}