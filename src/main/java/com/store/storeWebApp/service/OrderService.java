package com.store.storeWebApp.service;

import com.store.storeWebApp.exception.OrderNotFoundException;
import com.store.storeWebApp.model.order.OrderDb;
import com.store.storeWebApp.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public OrderDb saveOrder(OrderDb orderDb){
        OrderDb savedOrderDb = orderRepository.save(orderDb);
        return savedOrderDb;
    }
    public List<OrderDb> getAllOrders(){
        return orderRepository.findAll();
    }

    public OrderDb findOrderById(int id) throws OrderNotFoundException {
        OrderDb order = null;
        try {
            order = orderRepository.findByOrderId(id);
        }
        catch (Exception e){
            throw new OrderNotFoundException(id);
        }
        return order;
    }

    public void removeOrderById(int id){
        orderRepository.deleteById(id);
    }

}
