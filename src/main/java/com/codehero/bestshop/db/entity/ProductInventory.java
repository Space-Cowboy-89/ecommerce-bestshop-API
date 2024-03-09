package com.codehero.bestshop.db.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;

@Entity
@DynamicInsert
@Table(name="product_inventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer quantity;
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @Column(name = "modified_at")
    private Timestamp modifiedAt;
    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    public ProductInventory() {
    }

    public ProductInventory(Integer id, Integer quantity, Timestamp createdAt, Timestamp modifiedAt, Timestamp deletedAt) {
        this.id = id;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
