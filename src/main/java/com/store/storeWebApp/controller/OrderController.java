package com.store.storeWebApp.controller;
import com.store.storeWebApp.exception.OrderNotFoundException;
import com.store.storeWebApp.model.order.OrderDb;
import com.store.storeWebApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDb orderDb) {
        orderService.saveOrder(orderDb);

        return ResponseEntity.ok("Order placed successfully");
    }

    @PutMapping("/order/editOrderStatus/{id}")
    public ResponseEntity<OrderDb> editOrderStatus(@PathVariable(value = "id") int orderId,
                                             @RequestBody OrderDb orderFromRequest) throws OrderNotFoundException {

        OrderDb orderDb = orderService.findOrderById(orderId);
        orderDb.setOrderStatus(orderFromRequest.getOrderStatus());


        final OrderDb updatedOrder = orderService.saveOrder(orderDb);
        return ResponseEntity.ok(orderDb);
    }


    @GetMapping("/order/orders")
    List<OrderDb> getAllOrders(){
        List<OrderDb> orders = orderService.getAllOrders();
        return orders;
    }

    @GetMapping("/order/{id}")
    OrderDb getOrderById(@PathVariable int id) throws OrderNotFoundException {
        OrderDb order = orderService.findOrderById(id);
        return order;
    }

    @GetMapping("/order/delete/{id}")
    void deleteOrderById(@PathVariable int id){
        orderService.removeOrderById(id);
    }
}
