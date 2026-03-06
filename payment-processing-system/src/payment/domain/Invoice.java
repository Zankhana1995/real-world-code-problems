package payment.domain;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    String invoiceId;
    String contractor;
    String subcontractor;
    double totalAmount;

    public List<Payment> payments = new ArrayList<>();

    public Invoice(String invoiceId, String contractor, String subcontractor, double totalAmount) {
        this.invoiceId = invoiceId;
        this.contractor = contractor;
        this.subcontractor = subcontractor;
        this.totalAmount = totalAmount;
    }

    public double getPaidAmount() {

        double sum = 0;
        for (Payment p : payments) {
            sum += p.amount;
        }
        return sum;
    }

    public double getOutstandingBalance() {
        return totalAmount - getPaidAmount();
    }

    public InvoiceStatus getStatus() {

        double paid = getPaidAmount();
        if (paid == 0) {
            return InvoiceStatus.PENDING;
        } else if (paid < totalAmount) {
            return InvoiceStatus.PARTIALLY_PAID;
        } else {
            return InvoiceStatus.PAID;
        }
    }
}
