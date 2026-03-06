# Payment Processing System

## Explanation

This project implements a simple **invoice payment processing system**. Contractors can create invoices for subcontractors, and payments can be applied to those invoices over time. The system keeps track of the total invoice amount, payments made, remaining balance, and the current invoice status.

Each **Invoice** contains details such as:

- `invoiceId`
- `contractor`
- `subcontractor`
- `totalAmount`
- Payments applied to the invoice

A **Payment** represents an individual transaction with fields like:

- `paymentId`
- `amount`
- `timestamp`

The **PaymentService** manages invoices using a `HashMap`, allowing quick lookup by `invoiceId`.

It provides methods to:

1. Create a new invoice
2. Apply a payment to an invoice
3. Calculate the outstanding balance
4. Determine the invoice status (`PENDING`, `PARTIALLY_PAID`, `PAID`)

Payments are stored as a list inside each invoice. This allows the system to maintain a **history of all transactions** rather than just tracking the total paid amount.

## Validations

Basic validations are included to handle cases such as:

- Non-existent invoices
- Invalid payment amounts
- Overpayment scenarios

## Notes

For demonstration purposes, the data is stored **in memory**. In a real production system, this would typically be persisted in a database such as **MySQL**, with proper transaction handling to ensure data consistency.