package com.store.storeWebApp.controller;

import com.store.storeWebApp.model.customer.CustomerDb;
import com.store.storeWebApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/getAll")
    List<CustomerDb> getAllCustomerDbList(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/getBiggestCustomers")
    List<CustomerDb> getBiggestCustomerDbList(){
        return customerService.getBiggestCustomers();
    }

    @PostMapping("/customer/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerDb customer) {
        customerService.createNewCustomer(customer);

        return ResponseEntity.ok("User registered successfully");
    }

}
