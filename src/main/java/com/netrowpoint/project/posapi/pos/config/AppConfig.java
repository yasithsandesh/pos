package com.netrowpoint.project.posapi.pos.config;

import com.netrowpoint.project.posapi.pos.service.CustomerService;
import com.netrowpoint.project.posapi.pos.service.impl.CustomerServiceIMPL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerService customerService() {
        return new CustomerServiceIMPL(); // Replace with your actual implementation.
    }
}