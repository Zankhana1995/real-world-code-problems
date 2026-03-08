import java.util.HashMap;
import java.util.Map;

public class BankService {
    private Map<String, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    public void transfer(String fromId, String toId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive and greater than zero");
        }

        //fetch Accounts to transfer
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);

        if (from == null || to == null) {
            throw new IllegalArgumentException("Invalid account");
        }

        // synchronization to avoid race conditions if multiple transfers happen at the same time.
        synchronized (this) {
            if(from.getBalance() < amount) {
                throw new RuntimeException("Insufficient Fund");
            }

            from.debit(amount);
            to.credit(amount);
        }
    }

    public void printBalances() {
        for (Account account : accounts.values()) {
            System.out.println(account.getAccountId() + " balance: " + account.getBalance());
        }
    }

}
