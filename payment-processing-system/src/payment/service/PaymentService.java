package payment.service;

import payment.domain.Invoice;
import payment.domain.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    public Map<String, Invoice> invoices = new HashMap<>();

    public void createInvoice(String id, String contractor, String subcontractor, double amount) {
        if (!invoices.containsKey(id)) {
            Invoice invoice = new Invoice(id, contractor, subcontractor, amount);
            invoices.put(id, invoice);
        } else {
            throw new RuntimeException("Invoice is already exists");
        }
    }

    /**
     * synchronized (invoice) -> The lock is on that specific invoice object.
     * Meaning:
     * Only one thread can modify that invoice at a time
     * But other invoices can still be processed concurrently
     * <p>
     * synchronized(this) -> The lock is on the entire service object.
     * Meaning : Only one thread can execute this block in the whole service.
     */

    public void applyPayment(String invoiceId, String paymentId, double amount) {

        Invoice invoice = invoices.get(invoiceId);

        if (invoice == null) {
            throw new RuntimeException("Invoice not found");
        }

        Payment payment = new Payment(paymentId, amount);

        synchronized (invoice) {
            invoice.payments.add(payment);
        }
    }

    public void printPayments(String invoiceId) {

        Invoice invoice = invoices.get(invoiceId);

        for (Payment p : invoice.payments) {
            System.out.println(p.paymentId + " : " + p.amount);
        }
    }
}
