package com.store.storeWebApp.service;


import com.store.storeWebApp.model.item.ItemDb;
import com.store.storeWebApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Optional<ItemDb> findItem(int id){
        return  itemRepository.findById(id);
    }

    public ItemDb saveItem(ItemDb itemDb){
        ItemDb savedItem = itemRepository.save(itemDb);
        return savedItem;
    }

    public ItemDb getMostProfitableItem() throws Exception {
        List<ItemDb> allItems = itemRepository.findAll();
        try {
            ItemDb mostProfitable = allItems.get(0);
            for(ItemDb itemDb: allItems){
                if (itemDb.getItemSales()> mostProfitable.getItemSales()){
                    mostProfitable = itemDb;
                }
            }
            return mostProfitable;
        }catch (Exception e){
            throw new Exception();
        }

    }

    public void deleteItem(int id){
        itemRepository.deleteById(id);
    }

}
