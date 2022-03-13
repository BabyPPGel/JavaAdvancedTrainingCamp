package com.example.bank2.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountInfoService {
    public void updateAccountBalance(String accountNo, Double amount);
    public void confirmMethod(String accountNo, Double amount);
    public void cancelMethod(String accountNo, Double amount);
}
