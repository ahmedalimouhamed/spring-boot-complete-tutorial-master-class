package com.example;

import org.springframework.stereotype.Component;

public class Nurse implements Staff {
    @Override
    public void assist(){
        System.out.println("Nurse is assisting");
    }
}
