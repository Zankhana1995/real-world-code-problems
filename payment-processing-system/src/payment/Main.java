package payment;

import payment.domain.Invoice;
import payment.service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.createInvoice("INV1", "ContractorA", "SubA", 1000);
        service.createInvoice("INV2", "ContractorB", "SubB", 1000);

        service.applyPayment("INV1", "P1", 400);
        service.applyPayment("INV1", "P2", 200);
        service.applyPayment("INV1", "P3", 300);

        Invoice invoice = service.invoices.get("INV1");

        System.out.println("Paid: " + invoice.getPaidAmount());
        System.out.println("Outstanding: " + invoice.getOutstandingBalance());
        System.out.println("Status: " + invoice.getStatus());
    }
}
