public class Account {
    private String accountId;
    private double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount) {
        balance = balance - amount;
    }

    public void credit(double amount) {
        balance = balance + amount;
    }
}
