/**
 * THE POWER OF INTERFACES: Polymorphism
 * ======================================
 * This class works with any Payable — it never needs to know whether
 * it's dealing with a CreditCard, PayPal, or BankTransfer.
 *
 * If the store adds a new payment method next year (e.g., ApplePay),
 * this class requires ZERO changes. That's the core benefit of programming
 * to an interface rather than a specific class.
 */
public class Checkout {

    private String storeName;

    public Checkout(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Notice the parameter type: Payable — not CreditCard, not PayPal.
     * This method works with ANY class that implements Payable.
     */
    public void processOrder(String item, double price, Payable paymentMethod) {
        System.out.println("\n[" + storeName + "] Processing order: " + item);

        boolean success = paymentMethod.processPayment(price);

        if (success) {
            paymentMethod.printReceipt(price);
        } else {
            System.out.println("Order failed. Please try a different payment method.");
        }
    }
}
