package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class BeanConfig {



    @Bean
    public Nurse nurse(){
        return new Nurse();
    }
}
