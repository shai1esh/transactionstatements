package com.infy.transactionstatements.repository;

import com.infy.transactionstatements.model.AccountTransaction;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<AccountTransaction, Integer> {
  Optional<List<AccountTransaction>> findByAccountNumber(Integer accountNumber);
}
