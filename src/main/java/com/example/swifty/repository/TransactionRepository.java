package com.example.swifty.repository;

import com.example.swifty.entity.transaction_log.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Transaction} entities in the database.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
