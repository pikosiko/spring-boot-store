package com.store.storeWebApp.model.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class OrderDb {

    @Id
    private int orderId;

    private String orderStatus;
    private Double orderPrice;
    private int customerId;
    private String customerAddress;

    private int itemId;

    private Boolean madeByCustomer;

    public OrderDb(int orderId, String orderStatus, Double orderPrice, int customerId, String customerAddress, Boolean madeByCustomer, int itemId) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderPrice = orderPrice;
        this.customerId = customerId;
        this.customerAddress = customerAddress;
        this.madeByCustomer = madeByCustomer;
        this.itemId = itemId;
    }
}
