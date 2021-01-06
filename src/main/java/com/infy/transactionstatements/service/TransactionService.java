package com.infy.transactionstatements.service;

import com.infy.transactionstatements.model.AccountTransaction;
import com.infy.transactionstatements.repository.TransactionRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  public List<AccountTransaction> getTransactions(String accountNumber) {

    Optional<List<AccountTransaction>> transactions = transactionRepository
        .findByAccountNumber(Integer.parseInt(accountNumber));
    if (transactions.isPresent()) {
      return transactions.get();
    } else {
      LOGGER.info("No transactions found for the account number");
      return Collections.emptyList();
    }
  }
}