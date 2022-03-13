package com.example.bank2.controller;

import com.example.bank2.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bank2Controller {
    @Autowired
    AccountInfoService accountInfoService;

    @GetMapping("/transfer")
    public Boolean transfer(@RequestParam("amount") Double amount) {
        this.accountInfoService.updateAccountBalance("2", amount);
        return true;
    }

}

