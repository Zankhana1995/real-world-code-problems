public class BankAppMainClass {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        Account a1 = new Account("A1", 500);
        Account a2 = new Account("A2", 300);

        bankService.addAccount(a1);
        bankService.addAccount(a2);

        System.out.println("Before Transfer");
        bankService.printBalances();

        bankService.transfer("A1", "A2", 200);

        System.out.println("\nAfter transfer:");
        bankService.printBalances();
    }
}
