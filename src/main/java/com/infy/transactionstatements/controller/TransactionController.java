package com.infy.transactionstatements.controller;

import com.infy.transactionstatements.request.TransactionRequest;
import com.infy.transactionstatements.model.AccountTransaction;
import com.infy.transactionstatements.service.TransactionService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/transaction")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @PostMapping(value = "/getTransactions")
  public List<AccountTransaction> getAccountTransaction(
      @RequestBody @Valid TransactionRequest request) {
    LOGGER.info("Request received");
    List<AccountTransaction> transactions = transactionService
        .getTransactions(request.getAccountNumber());
    LOGGER.info("Request processing completed");
    return transactions;
  }
}
