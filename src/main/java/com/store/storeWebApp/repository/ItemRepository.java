package com.store.storeWebApp.repository;

import com.store.storeWebApp.model.item.ItemDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemDb, Integer> {
}
