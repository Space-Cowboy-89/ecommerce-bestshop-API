package com.codehero.bestshop.db.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;


//user_address ha una relazione oneToOne con User
@Entity
@Table(name = "user_address")
@DynamicInsert
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "address_line1")
    private String addressLine1;
    @Column(name = "address_line2")
    private String getAddressLine2;
    @Column
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column
    private String country;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public UserAddress() {
    }

    public UserAddress(String addressLine1, String getAddressLine2, String city, String postalCode, String country, User user) {
        this.addressLine1 = addressLine1;
        this.getAddressLine2 = getAddressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getGetAddressLine2() {
        return getAddressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setGetAddressLine2(String getAddressLine2) {
        this.getAddressLine2 = getAddressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
