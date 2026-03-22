/**
 * IMPLEMENTATION 2: PayPal Payment
 *
 * A completely different internal mechanism from CreditCard,
 * but it satisfies the same Payable contract.
 */
public class PayPal implements Payable {

    private String email;
    private double accountBalance;

    public PayPal(String email, double accountBalance) {
        this.email          = email;
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount > MAX_TRANSACTION_LIMIT) {
            System.out.println("[PayPal] Declined: exceeds transaction limit.");
            return false;
        }
        if (amount > accountBalance) {
            System.out.println("[PayPal] Declined: insufficient funds in PayPal balance.");
            return false;
        }
        accountBalance -= amount;
        System.out.printf("[PayPal] Approved $%.2f from %s (balance remaining: $%.2f)%n",
                          amount, email, accountBalance);
        return true;
    }

    @Override
    public String getPaymentSummary() {
        return "PayPal | " + email;
    }

    // Overriding the default method to add PayPal-specific branding.
    @Override
    public void printReceipt(double amount) {
        System.out.println("====== PayPal Receipt ======");
        System.out.println(getPaymentSummary());
        System.out.printf("Amount: $%.2f%n", amount);
        System.out.println("Thank you for using PayPal!");
        System.out.println("============================");
    }
}
