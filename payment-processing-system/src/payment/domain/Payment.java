package payment.domain;

public class Payment {
    public String paymentId;
    public double amount;
    public long timestamp;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }
}
