package com.netrowpoint.project.posapi.pos.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id",length = 45)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_fname",length = 45,nullable = false)
    private String customerFirstName;

    @Column(name = "customer_lname",length = 45,nullable = false)
    private String customerLastName;

    @Column(name = "customer_mobile",length = 10,nullable = false)
    private int customerMobile;

    @Column(name = "customer_email",length = 100,nullable = false)
    private String customerEmail;

    @Column(name = "customer_point", length = 100)
    private int customerPoints;

    @OneToMany(mappedBy="customer")
    private Set<Invoice> invoices;

    public Customer(){

    }

    public Customer(int customerId, String customerFirstName, String customerLastName, int customerMobile, String customerEmail, int customerPoints) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.customerPoints = customerPoints;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public int getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(int customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerPoints() {
        return customerPoints;
    }

    public void setCustomerPoints(int customerPoints) {
        this.customerPoints = customerPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerMobile=" + customerMobile +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPoints=" + customerPoints +
                '}';
    }
}
