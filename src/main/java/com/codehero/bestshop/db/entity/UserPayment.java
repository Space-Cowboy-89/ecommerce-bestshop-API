package com.codehero.bestshop.db.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Entity
@Table(name = "user_payment")
@DynamicInsert
public class UserPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "payment_type")
    private String paymentType;
    @Column
    private String provider;
    @Column(name = "account_num")
    private String accountNum;
    @Column
    private LocalDate expiry;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public UserPayment() {
    }

    public UserPayment(String paymentType, String provider, String accountNum, LocalDate expiry, User user) {
        this.paymentType = paymentType;
        this.provider = provider;
        this.accountNum = accountNum;
        this.expiry = expiry;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getProvider() {
        return provider;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
