package com.store.storeWebApp.model.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerDb {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private int customerPhone;

    public CustomerDb(int customerId, String customerName, String customerAddress, int customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }
}
