# Java Interfaces — Classroom Practical Example

> **Topic:** Interfaces, Polymorphism & Default Methods | **Language:** Java 8+

---

## Project Overview

This project implements a **Payment Processing System** to demonstrate Java Interfaces in a real-world context. A store needs to accept multiple payment methods — `CreditCard`, `PayPal`, and `BankTransfer`. Each works completely differently internally, but all satisfy the same `Payable` contract.

The `Checkout` class processes orders without ever knowing which concrete payment type it is dealing with. This is the core benefit of programming to an interface rather than a specific class.

---

## Files

| File | Role |
|---|---|
| `Payable.java` | The interface — defines the contract: `processPayment()`, `getPaymentSummary()`, a default `printReceipt()` method, and the `MAX_TRANSACTION_LIMIT` constant |
| `CreditCard.java` | Implementation 1 — enforces a credit limit; uses the default `printReceipt()` |
| `PayPal.java` | Implementation 2 — deducts from account balance; overrides `printReceipt()` with custom branding |
| `BankTransfer.java` | Implementation 3 — requires account verification before approving |
| `Checkout.java` | Uses `Payable` polymorphically — works with any implementation without knowing the concrete type |
| `Main.java` | Entry point — runs 5 scenarios covering success, declines, and polymorphic iteration |

---

## Concepts Demonstrated

1. **Contract Enforcement** — `implements Payable` forces every class to provide `processPayment()` and `getPaymentSummary()`, or the code will not compile.

2. **Polymorphism** — `Payable` variables can hold `CreditCard`, `PayPal`, or `BankTransfer` objects. `Checkout.processOrder()` accepts any `Payable`.

3. **Default Methods (Java 8+)** — `printReceipt()` provides shared behaviour across all implementations. `PayPal` overrides it with a custom branded receipt.

4. **Interface Constants** — `MAX_TRANSACTION_LIMIT = 10_000.00` is implicitly `public`, `static`, and `final` — accessible from any implementing class.

5. **Open/Closed Principle** — adding a new payment method (e.g., `ApplePay`) requires zero changes to `Checkout` or `Main`.

---

## How to Compile and Run

```bash
# Compile all .java files in the current directory
javac *.java

# Run the program
java Main
```

---

## Sample Output

```
============================================
   Interface Transaction limit: $10000.0
============================================

[Java Goods Online] Processing order: Wireless Keyboard
[Credit Card] Approved $79.99 on card ending in 4242
------ RECEIPT ------
Credit Card | Alice Johnson | **** 4242
Amount Charged: $79.99
---------------------

[Java Goods Online] Processing order: USB-C Hub
[PayPal] Approved $49.99 from alice@email.com (balance remaining: $450.01)
====== PayPal Receipt ======
PayPal | alice@email.com
Amount: $49.99
Thank you for using PayPal!
============================

[Java Goods Online] Processing order: Monitor Stand
[Bank Transfer] Initiated $129.99 from First National account ****7890
------ RECEIPT ------
Bank Transfer | First National | Acct: ****7890
Amount Charged: $129.99
---------------------

[Java Goods Online] Processing order: Laptop
[Bank Transfer] Declined: account not verified.
Order failed. Please try a different payment method.

[Java Goods Online] Processing order: Ultra-Wide Monitor
[Credit Card] Declined: exceeds transaction limit.
Order failed. Please try a different payment method.

--- All payment methods are type Payable ---
  Credit Card | Alice Johnson | **** 4242
  PayPal | alice@email.com
  Bank Transfer | First National | Acct: ****7890
```

---

## Key Takeaway

> *"Program to an interface, not an implementation."*

The `Checkout` class never imports `CreditCard`, `PayPal`, or `BankTransfer` — it only knows about `Payable`. This keeps the system decoupled: you can add new payment methods, swap implementations, or write unit tests with mock payment objects, all without touching the code that processes orders.
