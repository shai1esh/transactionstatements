package com.infy.transactionstatements.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.transactionstatements.TransactionStatementsApplication;
import com.infy.transactionstatements.model.AccountTransaction;
import com.infy.transactionstatements.request.TransactionRequest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = TransactionStatementsApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT)
class TransactionControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Sql({"classpath:data.sql"})
  @Test
  void getAccountTransaction() throws JsonProcessingException {

    TransactionRequest request = TransactionRequest.builder()
        .accountNumber("12345663")
        .build();

    ResponseEntity<String> responseEntity = this.restTemplate
        .postForEntity("http://localhost:" + port + "/transaction/getTransactions", request,
            String.class);
    ObjectMapper objectMapper = new ObjectMapper();
    List<AccountTransaction> list = objectMapper.readValue(responseEntity.getBody(),
        objectMapper.getTypeFactory().constructCollectionType(List.class, AccountTransaction.class));

    assertNotNull(responseEntity.getBody());
    assertEquals(12345663, list.get(0).getAccountNumber());
    assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
  }

  @Sql({"classpath:data.sql"})
  @Test
  void getAccountTransactionEmpty() throws JsonProcessingException {

    TransactionRequest request = TransactionRequest.builder()
        .accountNumber("1234566486")
        .build();

    ResponseEntity<String> responseEntity = this.restTemplate
        .postForEntity("http://localhost:" + port + "/transaction/getTransactions", request,
            String.class);
    ObjectMapper objectMapper = new ObjectMapper();
    List<AccountTransaction> transactions = objectMapper.readValue(responseEntity.getBody(), objectMapper.getTypeFactory()
        .constructCollectionType(List.class, AccountTransaction.class));

    assertEquals(0, transactions.size());
    assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
  }


  @Test
  void getAccountTransactionInvalidInput() {

    TransactionRequest request = TransactionRequest.builder()
        .accountNumber("12345664873293080203")
        .build();

    ResponseEntity<String> responseEntity = this.restTemplate
        .postForEntity("http://localhost:" + port + "/transaction/getTransactions", request,
            String.class);

    assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
  }
}