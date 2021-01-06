# transactionstatements
Rest spring boot demo for account and transaction details

## Features
 * View account details
 * View transactions for the given account

## Setup and Tech stack
The application can be run locally, the requirements for each setup are below.
* Intellij --> need to import in intellij 
* H2 Database -->  can be viewed on browser (no setup needed)

## API:
* Account API
```curl
curl -X GET "http://localhost:8080/account/getAccounts"
```

* Transaction API
```curl
curl --request POST --url http://localhost:8080/transaction/getTransactions --header 'content-type: application/json' --data '{"accountNumber" : "12345667"}'
```

## Developer
Shailesh Shinde