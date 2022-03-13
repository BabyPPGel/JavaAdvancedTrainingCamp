package com.example.demo.feign;

import org.springframework.stereotype.Component;

@Component
public class Bank2ClientFallback implements Bank2Client {

    public Boolean transfer(Double amount) {
        return false;
    }
}
