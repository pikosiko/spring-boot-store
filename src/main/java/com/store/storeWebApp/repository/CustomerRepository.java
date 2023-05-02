package com.store.storeWebApp.repository;

import com.store.storeWebApp.model.customer.CustomerDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDb, Integer> {



}
