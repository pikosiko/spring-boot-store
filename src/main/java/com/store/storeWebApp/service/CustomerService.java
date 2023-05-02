package com.store.storeWebApp.service;


import com.store.storeWebApp.model.customer.CustomerDb;
import com.store.storeWebApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDb> getAllCustomers(){
        return customerRepository.findAll();
    }

    //stub
    public List<CustomerDb> getBiggestCustomers(){
        return null;
    }

    public void createNewCustomer(CustomerDb customerDb){
        customerRepository.save(customerDb);
    }
}
