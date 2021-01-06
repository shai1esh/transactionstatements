package com.infy.transactionstatements.controller;

import com.infy.transactionstatements.model.Account;
import com.infy.transactionstatements.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @GetMapping(value = "/getAccounts", produces="application/json")
  public List<Account> getAllAccounts(){
    return accountService.getAccounts();
  }
}
