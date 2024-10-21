package com.netrowpoint.project.posapi.pos.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class CustomerDTO {

    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private int customerMobile;
    private String customerEmail;
    private int customerPoints;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerFirstName, String customerLastName, int customerMobile, String customerEmail, int customerPoints) {
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
}
