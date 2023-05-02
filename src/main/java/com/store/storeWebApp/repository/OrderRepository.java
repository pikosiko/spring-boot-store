package com.store.storeWebApp.repository;

import com.store.storeWebApp.model.order.OrderDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDb, Integer>{

    public OrderDb findByOrderId(int id);
}
