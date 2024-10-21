package com.netrowpoint.project.posapi.pos.service.impl;

import com.netrowpoint.project.posapi.pos.dto.CustomerDTO;
import com.netrowpoint.project.posapi.pos.dto.request.UpdateCustomerDTO;
import com.netrowpoint.project.posapi.pos.entity.Customer;
import com.netrowpoint.project.posapi.pos.repo.CustomerRepo;
import com.netrowpoint.project.posapi.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerFirstName(),
                customerDTO.getCustomerLastName(),
                customerDTO.getCustomerMobile(),
                customerDTO.getCustomerEmail(),
                customerDTO.getCustomerPoints()
        );

//        private int customerId;
//        private String customerFirstName;
//        private String customerLastName;
//        private int customerMobile;
//        private String customerEmail;
//        private int customerPoints; //DTO

        customerRepo.save(customer);

        return null;
    }

    @Override
    public String updateCustomer(UpdateCustomerDTO updateCustomerDTO) {
        if (customerRepo.existsById(updateCustomerDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(updateCustomerDTO.getCustomerId());

            customer.setCustomerMobile(updateCustomerDTO.getCustomerMobile());
            customer.setCustomerEmail(updateCustomerDTO.getCustomerEmail());

            customerRepo.save(customer);

            return "update sucess";
        }else {
            return "no data found for that id";
        }
    }

    @Override
    public CustomerDTO getCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerFirstName(),
                    customer.getCustomerLastName(),
                    customer.getCustomerMobile(),
                    customer.getCustomerEmail(),
                    customer.getCustomerPoints()
            );

            return customerDTO;
        }else {

        }
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : getAllCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerFirstName(),
                    customer.getCustomerLastName(),
                    customer.getCustomerMobile(),
                    customer.getCustomerEmail(),
                    customer.getCustomerPoints()
            );

            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "delete sucess";
        }else {
            return "no data found for that id";
        }

    }
}
