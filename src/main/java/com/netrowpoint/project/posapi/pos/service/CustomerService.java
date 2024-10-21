package com.netrowpoint.project.posapi.pos.service;

import com.netrowpoint.project.posapi.pos.dto.CustomerDTO;
import com.netrowpoint.project.posapi.pos.dto.request.UpdateCustomerDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(UpdateCustomerDTO updateCustomerDTO);

    public CustomerDTO getCustomer(int customerId);

    public List<CustomerDTO> getAllCustomers();

    public String deleteCustomer(int customerId);
}
