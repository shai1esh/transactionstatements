package com.infy.transactionstatements.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.infy.transactionstatements.model.Account;
import com.infy.transactionstatements.repository.AccountRepository;
import com.infy.transactionstatements.util.TestDataUtil;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

  @InjectMocks
  private AccountService accountService;

  @Mock
  private AccountRepository accountRepository;

  @Test
  void testGetAccounts() {

    List<Account> accountList = List
        .of(TestDataUtil.buildAccount(123456678));
    when(accountRepository.findAll()).thenReturn(accountList);
    List<Account> accounts = accountService.getAccounts();

    assertEquals(1, accounts.size());
  }

  @Test
  void TestGetEmptyAccounts() {

    when(accountRepository.findAll()).thenReturn(Collections.emptyList());
    List<Account> accounts = accountService.getAccounts();

    assertEquals(0, accounts.size());
  }
}