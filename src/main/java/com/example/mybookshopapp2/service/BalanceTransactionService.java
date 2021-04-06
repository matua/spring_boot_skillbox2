package com.example.mybookshopapp2.service;

import com.example.mybookshopapp2.model.BalanceTransaction;
import com.example.mybookshopapp2.respository.BalanceTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceTransactionService {
    private final BalanceTransactionRepository balanceTransactionRepository;

    @Autowired
    public BalanceTransactionService(BalanceTransactionRepository balanceTransactionRepository) {
        this.balanceTransactionRepository = balanceTransactionRepository;
    }

    public List<BalanceTransaction> getAllBalanceTransactions() {
        return balanceTransactionRepository.findAll();
    }
}
