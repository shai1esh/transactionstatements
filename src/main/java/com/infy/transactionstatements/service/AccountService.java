package com.infy.transactionstatements.service;

import com.infy.transactionstatements.model.Account;
import com.infy.transactionstatements.repository.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService  {

  @Autowired
  private AccountRepository accountRepository;

  public List<Account> getAccounts() {
    return accountRepository.findAll();
  }
}