package com.codehero.bestshop.db.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user")
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column()
    private String username;
    @Column()
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "cellphone_num")
    private String cellphoneNum;
    @Column(name = "homephone_num")
    private String homephoneNum;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "modified_at")
    private Timestamp modifiedAt;
    @OneToOne(mappedBy = "user")
    private UserAddress userAddress;
    @OneToMany(mappedBy = "user")
    private List<UserPayment> userPaymentList;
    @OneToOne(mappedBy = "user")
    private ShoppingSession shoppingSession;

    public User() {
    }

    public User(Integer id, String username, String password, String firstName, String lastName, String cellphoneNum, String homephoneNum, Timestamp createdAt, Timestamp modifiedAt, UserAddress userAddress, List<UserPayment> userPaymentList, ShoppingSession shoppingSession) {
        Id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellphoneNum = cellphoneNum;
        this.homephoneNum = homephoneNum;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.userAddress = userAddress;
        this.userPaymentList = userPaymentList;
        this.shoppingSession = shoppingSession;
    }

    public ShoppingSession getShoppingSession() {
        return shoppingSession;
    }

    public Integer getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public List<UserPayment> getUserPaymentList() {
        return userPaymentList;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCellphoneNum() {
        return cellphoneNum;
    }

    public String getHomephoneNum() {
        return homephoneNum;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserPaymentList(List<UserPayment> userPaymentList) {
        this.userPaymentList = userPaymentList;
    }

    public void setShoppingSession(ShoppingSession shoppingSession) {
        this.shoppingSession = shoppingSession;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCellphoneNum(String cellphoneNum) {
        this.cellphoneNum = cellphoneNum;
    }

    public void setHomephoneNum(String homephoneNum) {
        this.homephoneNum = homephoneNum;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
