package com.store.storeWebApp.exception;

public class ItemNotFoundException extends Exception{

    public ItemNotFoundException(int id) {
        super("Could not find item unit with id: " + id);
    }
}
