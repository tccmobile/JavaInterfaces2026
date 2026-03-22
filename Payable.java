/**
 * JAVA INTERFACES - Practical Classroom Example
 * ==============================================
 * Scenario: A Payment Processing System
 *
 * WHY AN INTERFACE HERE?
 * A store needs to accept multiple payment methods (credit card, PayPal,
 * bank transfer). Each method works differently internally, but the store
 * only cares about ONE thing: can it process a payment?
 *
 * An interface defines a CONTRACT — a guarantee that any class implementing
 * it will provide these methods, regardless of how they work internally.
 */
public interface Payable {

    // Every class that implements Payable MUST provide these methods.
    // There are no method bodies here — just the signatures (the contract).

    boolean processPayment(double amount);

    String getPaymentSummary();

    // DEFAULT METHOD (Java 8+): Optional — implementors can override or keep this.
    // Useful for shared behavior that makes sense across all implementations.
    default void printReceipt(double amount) {
        System.out.println("------ RECEIPT ------");
        System.out.println(getPaymentSummary());
        System.out.printf("Amount Charged: $%.2f%n", amount);
        System.out.println("---------------------");
    }

    // CONSTANT: Interface fields are implicitly public, static, and final.
    double MAX_TRANSACTION_LIMIT = 10_000.00;
}
