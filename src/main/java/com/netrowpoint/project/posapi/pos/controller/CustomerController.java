package com.netrowpoint.project.posapi.pos.controller;

import com.netrowpoint.project.posapi.pos.dto.CustomerDTO;
import com.netrowpoint.project.posapi.pos.dto.request.UpdateCustomerDTO;
import com.netrowpoint.project.posapi.pos.service.CustomerService;
import com.netrowpoint.project.posapi.pos.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired(required = true)
    private CustomerService customerService;//dipendance injection reapt object overload ram


    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "sucess";
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody UpdateCustomerDTO updateCustomerDTO){
     String message = customerService.updateCustomer(updateCustomerDTO);
     return message;
    }

    @GetMapping(path = "/customer",params = "id")
    public CustomerDTO getCustomer(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomer(customerId);
        return customerDTO;
    }

    @GetMapping(path = "/get-all-customer")
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return customers;
    }

    @DeleteMapping(
            path = "/delete/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleteMessage = customerService.deleteCustomer(customerId);
        return deleteMessage;
    }
}
