package org.example;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    //logging
    //authentication & authorization
    //sanitize the data
    public void checkout(String status){
        System.out.println("Checkout method from shoppingCart called");
    }

    public int quantity(){
        return 2;
    }
}
