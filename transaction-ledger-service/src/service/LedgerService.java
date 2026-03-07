package service;

import domain.Account;
import domain.Transaction;
import domain.TransactionType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LedgerService {

    // In-memory database
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String userId) {
        if (accounts.containsKey(userId)) {
            throw new RuntimeException("Account already exists");
        }
        accounts.put(userId, new Account(userId));
    }

    public void deposit(String userId, double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        Account account = accounts.get(userId);

        if (account == null) {
            throw new RuntimeException("Account not found");
        }

        Transaction transaction = new Transaction(UUID.randomUUID().toString(), TransactionType.DEPOSIT, amount);

        account.addTransaction(transaction);
    }

    public void withdraw(String userId, double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        Account account = accounts.get(userId);

        if (account == null) {
            throw new RuntimeException("Account not found");
        }

        Transaction transaction = new Transaction(UUID.randomUUID().toString(), TransactionType.WITHDRAW, amount);

        account.addTransaction(transaction);
    }

    public double getBalance(String userId) {
        Account account = accounts.get(userId);

        if (account == null) {
            throw new RuntimeException("Account not found");
        }

        return account.balance;
    }

    public void printTransactions(String userId) {
        Account account = accounts.get(userId);

        if (account == null) {
            throw new RuntimeException("Account not found");
        }

        account.transactions.forEach(transaction ->
                System.out.println(transaction.type + " : " + transaction.amount));
    }
}
