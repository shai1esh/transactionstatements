package com.infy.transactionstatements.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.infy.transactionstatements.TransactionStatementsApplication;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = TransactionStatementsApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT)
class AccountControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Sql({"classpath:data.sql"})
  @Test
  void testGetAllAccounts() {
    assertEquals(5, this.restTemplate
        .getForObject("http://localhost:" + port + "/account/getAccounts", List.class)
        .size());
  }
}