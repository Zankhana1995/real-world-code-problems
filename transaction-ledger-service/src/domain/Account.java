package domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public String userId;
    public double balance;
    public List<Transaction> transactions;

    public Account(String userId) {
        this.userId = userId;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {

        if (transaction.type == TransactionType.DEPOSIT) {
            balance += transaction.amount;
        } else {
            balance -= transaction.amount;
        }

        transactions.add(transaction);
    }
}
