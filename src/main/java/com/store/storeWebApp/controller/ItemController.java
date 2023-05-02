package com.store.storeWebApp.controller;

import com.store.storeWebApp.exception.ItemNotFoundException;
import com.store.storeWebApp.model.item.ItemDb;
import com.store.storeWebApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item/mostProfitable")
    ItemDb getMostProfitable() throws Exception {
        return itemService.getMostProfitableItem();
    }

    @GetMapping("/item/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);

        return ResponseEntity.ok("Item deleted successfully");
    }

    @PostMapping("/item/create")
    public ResponseEntity<String> createItem(@RequestBody ItemDb itemDb) {
        itemService.saveItem(itemDb);

        return ResponseEntity.ok("User registered successfully");
    }

    @PutMapping("/item/edit/{id}")
    public ResponseEntity<ItemDb> updateItem(@PathVariable(value = "id") int itemId,
                                            @RequestBody ItemDb itemFromRequest) throws ItemNotFoundException {
        ItemDb item = itemService.findItem(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));

        item.setItemQuantity(itemFromRequest.getItemQuantity());
        item.setItemSales(itemFromRequest.getItemSales());
        item.setItemPrice(itemFromRequest.getItemPrice());


        final ItemDb updatedItem = itemService.saveItem(item);
        return ResponseEntity.ok(updatedItem);
    }
}
