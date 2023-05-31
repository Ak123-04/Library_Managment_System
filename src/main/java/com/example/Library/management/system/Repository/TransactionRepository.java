package com.example.Library.management.system.Repository;

import com.example.Library.management.system.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
