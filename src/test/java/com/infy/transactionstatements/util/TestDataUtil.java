package com.infy.transactionstatements.util;

import com.infy.transactionstatements.model.Account;
import com.infy.transactionstatements.model.AccountTransaction;
import java.sql.Date;

public class TestDataUtil {

  public static AccountTransaction buildAccountTransaction(int accountNumber) {
    return AccountTransaction.builder()
        .accountName("Shailesh")
        .accountNumber(accountNumber)
        .currency("AUD")
        .debitAmount(120.18)
        .transactionId(1220812122)
        .build();
  }

  public static Account buildAccount(int accountNumber) {
    return Account.builder()
        .accountName("Shailesh")
        .accountNumber(accountNumber)
        .currency("AUD")
        .accountType("Savings")
        .balance(10002.2)
        .balanceDate(Date.valueOf("2019-01-12"))
        .build();
  }
}
