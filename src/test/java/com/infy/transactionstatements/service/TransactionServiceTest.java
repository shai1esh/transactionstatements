package com.infy.transactionstatements.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.infy.transactionstatements.model.AccountTransaction;
import com.infy.transactionstatements.repository.TransactionRepository;
import com.infy.transactionstatements.util.TestDataUtil;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest{

  @InjectMocks
  private TransactionService transactionService;

  @Mock
  private TransactionRepository transactionRepository;

  @Test
  void getTransactionsSuccess() {

    final int accountNumber = 12345667;
    AccountTransaction accountTransaction = TestDataUtil.buildAccountTransaction(
        accountNumber);
    List<AccountTransaction> transactions = List.of(accountTransaction);

    when(transactionRepository.findByAccountNumber(accountNumber))
        .thenReturn(Optional.of(transactions));

    List<AccountTransaction> accountTransactions = transactionService
        .getTransactions(String.valueOf(accountNumber));
    assertEquals(1, accountTransactions.size());
    assertEquals(accountNumber, accountTransactions.get(0).getAccountNumber());
  }

  @Test
  void getTransactionsWithZeroTransaction() {

    final int accountNumber = 12345667;

    when(transactionRepository.findByAccountNumber(accountNumber))
        .thenReturn(Optional.of(Collections.emptyList()));

    List<AccountTransaction> accountTransactions = transactionService
        .getTransactions(String.valueOf(accountNumber));
    assertEquals(0, accountTransactions.size());
  }
}