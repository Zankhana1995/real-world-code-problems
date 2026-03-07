package domain;

public class Transaction {
    String transactionId;
    public TransactionType type;
    public double amount;
    long timestamp;

    public Transaction(String transactionId, TransactionType type, double amount) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }
}
