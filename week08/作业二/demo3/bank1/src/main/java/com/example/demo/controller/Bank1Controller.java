package com.example.demo.controller;

import com.example.demo.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bank1Controller {
    @Autowired
    AccountInfoService accountInfoService;

    @GetMapping("/transfer")
    public Boolean transfer(@RequestParam("amount") Double amount) {
        this.accountInfoService.updateAccountBalance("1", amount);
        return true;
    }

}
