package com.store.storeWebApp.model.item;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "items")
public class ItemDb {

    private int itemId;
    private double itemPrice;
    private int itemQuantity;

    private int itemSales;

    public ItemDb(int itemId, double itemPrice, int itemQuantity, int itemSales) {
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemSales = itemSales;
    }
}
