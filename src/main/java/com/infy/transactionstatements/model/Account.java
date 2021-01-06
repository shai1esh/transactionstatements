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
@Entity(name = "ACCOUNTS")
public class Account {

  @Id
  @Column(name = "ACC_NUMBER")
  private int accountNumber;

  @Column(name = "ACC_NAME")
  private String accountName;

  @Column(name = "ACC_TYPE")
  private String accountType;

  @Column(name = "BALANCE_DATE")
  private Date balanceDate;

  @Column(name = "CURRENCY")
  private String currency;

  @Column(name = "BALANCE")
  private double balance;
}
