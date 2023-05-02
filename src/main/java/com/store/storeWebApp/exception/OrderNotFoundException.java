package com.store.storeWebApp.exception;


public class OrderNotFoundException extends Exception{
;

    public OrderNotFoundException(int id) {
        super("Could not find order unit with id: " + id);
    }
}
