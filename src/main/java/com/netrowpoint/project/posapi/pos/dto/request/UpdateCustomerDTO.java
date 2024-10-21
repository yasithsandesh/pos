package com.netrowpoint.project.posapi.pos.dto.request;

public class UpdateCustomerDTO {
private int customerId;
private int customerMobile;
private String customerEmail;

    public UpdateCustomerDTO() {

    }

    public UpdateCustomerDTO(int customerId, int customerMobile, String customerEmail) {
        this.customerId = customerId;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {
        return "UpdateCustomerDTO{" +
                "customerId=" + customerId +
                ", customerMobile=" + customerMobile +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
