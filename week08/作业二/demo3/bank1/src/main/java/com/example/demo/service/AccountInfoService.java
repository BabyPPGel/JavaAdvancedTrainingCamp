package com.example.demo.service;

public interface AccountInfoService {
    public void updateAccountBalance(String accountNo, Double amount) ;
    public void commit(String accountNo, Double amount) ;
    public void rollback(String accountNo, Double amount);
}
