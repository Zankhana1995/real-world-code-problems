# Transaction Ledger System

## Overview

This project implements a simple **transaction ledger system** in Java that allows users to manage account balances and track financial transactions. The system supports creating accounts, depositing money, withdrawing funds, checking balances, and viewing transaction history.

The goal of this project is to demonstrate **clean object-oriented design, transaction tracking, and basic validation logic**.

---

## Features

- Create a user account
- Deposit money into an account
- Withdraw money from an account
- Prevent withdrawals exceeding available balance
- Track all transactions in a ledger
- Retrieve account balance
- View transaction history

---

## Core Components

### Account

Represents a user account and stores:

- `userId`
- `balance`
- List of transactions

The account updates its balance whenever a new transaction is added.

---

### Transaction

Represents a financial transaction and stores:

- `transactionId`
- `type` (DEPOSIT or WITHDRAW)
- `amount`
- `timestamp`

Each transaction is recorded in the account's ledger.

---

### LedgerService

Manages all accounts in the system using an in-memory `HashMap`.

Responsibilities:

1. Create new accounts
2. Handle deposits
3. Handle withdrawals
4. Retrieve account balance
5. Print transaction history

---

## Example Workflow

Example operations:

```
createAccount("David")

deposit("David", 100)
deposit("David", 200)

withdraw("David", 50)
```

Balance calculation:

```
100 + 200 - 50 = 250
```

Transaction history:

```
DEPOSIT : 100
DEPOSIT : 200
WITHDRAW : 50
```

---

## Running the Application

Compile the project:

```
javac *.java
```

Run the program:

```
java Main
```

Example output:

```
Balance: 250

Transaction History:
DEPOSIT : 100
DEPOSIT : 200
WITHDRAW : 50
```

---

## Validations

The system handles basic validations including:

- Preventing duplicate account creation
- Ensuring transaction amounts are positive
- Preventing withdrawals that exceed available balance
- Handling non-existent accounts

---

## Future Improvements

Possible improvements for a production-ready system:

- Persist data using **MySQL or PostgreSQL**
- Expose functionality through **REST APIs using Spring Boot**
- Implement **transaction management**
- Add **concurrency handling**
- Introduce **audit logging and monitoring**

---