package com.infy.transactionstatements.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TRANSACTIONS")
public class AccountTransaction {

  @Id
  @Column(name = "TRANSACTION_ID")
  private int transactionId;

  @Column(name = "ACC_NUMBER")
  private int accountNumber;

  @Column(name = "ACC_NAME")
  private String accountName;

  @Column(name = "VALUE_DATE")
  private Date valueDate;

  @Column(name = "CURRENCY")
  private String currency;

  @Column(name = "DEBIT_AMOUNT")
  private double debitAmount;

  @Column(name = "CREDIT_AMOUNT")
  private double creditAmount;

  @Column(name = "DEBIT_CREDIT_INDICATOR")
  private String debitCreditIndicator;

  @Column(name = "TRANS_NARRATIVE")
  private String transactionNarrative;
}
