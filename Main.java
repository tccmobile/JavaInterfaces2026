/**
 * Main.java — Run this to see everything in action.
 *
 * Key concepts demonstrated:
 *   1. A class IMPLEMENTS an interface (signs the contract)
 *   2. Multiple classes can implement the same interface
 *   3. An interface variable can hold ANY implementing object (polymorphism)
 *   4. Default methods provide shared behavior that can be overridden
 *   5. Interface constants are accessible from any implementing class
 */
public class Main {

    public static void main(String[] args) {

        // --- Setup ---
        Checkout store = new Checkout("Java Goods Online");

        // Three different objects, all stored as type Payable
        Payable card     = new CreditCard("Alice Johnson", "4242", 2000.00);
        Payable paypal   = new PayPal("alice@email.com", 500.00);
        Payable transfer = new BankTransfer("First National", "****7890", true);
        Payable unverified = new BankTransfer("Unknown Bank", "****0000", false);

        System.out.println("============================================");
        System.out.println("   Interface Transaction limit: $" + Payable.MAX_TRANSACTION_LIMIT);
        System.out.println("============================================");


        // --- Scenario 1: Successful credit card payment ---
        store.processOrder("Wireless Keyboard", 79.99, card);


        // --- Scenario 2: PayPal with custom receipt (overridden default method) ---
        store.processOrder("USB-C Hub", 49.99, paypal);


        // --- Scenario 3: Successful bank transfer ---
        store.processOrder("Monitor Stand", 129.99, transfer);


        // --- Scenario 4: Declined — unverified bank account ---
        store.processOrder("Laptop", 899.99, unverified);


        // --- Scenario 5: Declined — exceeds the interface constant limit ---
        store.processOrder("Ultra-Wide Monitor", 15_000.00, card);


        // --- KEY INSIGHT: Interface as a type ---
        System.out.println("\n--- All payment methods are type Payable ---");
        Payable[] methods = { card, paypal, transfer };
        for (Payable method : methods) {
            // We call getPaymentSummary() without knowing the concrete type
            System.out.println("  " + method.getPaymentSummary());
        }
    }
}
