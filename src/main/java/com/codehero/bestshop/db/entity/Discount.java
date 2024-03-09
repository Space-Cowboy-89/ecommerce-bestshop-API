package com.codehero.bestshop.db.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;

@Entity
@DynamicInsert
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    public Discount() {
    }

    public Discount(Integer id, String name, String desc, Double discountPercent, Boolean active, Timestamp createdAt, Timestamp modifiedAt, Timestamp deletedAt) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.discountPercent = discountPercent;
        this.active=active;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(Boolean active){
        this.active=active;
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
}
