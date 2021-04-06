package com.example.mybookshopapp2.respository;

import com.example.mybookshopapp2.model.BalanceTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceTransactionRepository extends JpaRepository<BalanceTransaction, Integer> {
}
