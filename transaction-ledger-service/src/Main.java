import service.LedgerService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LedgerService ledger = new LedgerService();

        ledger.createAccount("David");

        ledger.deposit("David", 100);
        ledger.deposit("David", 200);

        ledger.withdraw("David", 50);

        System.out.println("Balance: " + ledger.getBalance("David"));

        System.out.println("\nTransaction History:");
        ledger.printTransactions("David");
    }
}