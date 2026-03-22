/**
 * IMPLEMENTATION 1: Credit Card Payment
 *
 * This class signs the Payable contract by using "implements Payable".
 * It MUST provide a body for every non-default method in the interface,
 * or the compiler will throw an error.
 */
public class CreditCard implements Payable {

    private String cardholderName;
    private String lastFourDigits;
    private double creditLimit;
    private double currentBalance;

    public CreditCard(String cardholderName, String lastFourDigits,
                      double creditLimit) {
        this.cardholderName  = cardholderName;
        this.lastFourDigits  = lastFourDigits;
        this.creditLimit     = creditLimit;
        this.currentBalance  = 0.0;
    }

    // Fulfilling the contract: implementing processPayment()
    @Override
    public boolean processPayment(double amount) {
        if (amount > MAX_TRANSACTION_LIMIT) {
            System.out.println("[Credit Card] Declined: exceeds transaction limit.");
            return false;
        }
        if (currentBalance + amount > creditLimit) {
            System.out.println("[Credit Card] Declined: insufficient credit.");
            return false;
        }
        currentBalance += amount;
        System.out.printf("[Credit Card] Approved $%.2f on card ending in %s%n",
                          amount, lastFourDigits);
        return true;
    }

    // Fulfilling the contract: implementing getPaymentSummary()
    @Override
    public String getPaymentSummary() {
        return String.format("Credit Card | %s | **** %s", cardholderName, lastFourDigits);
    }

    // This class does NOT override printReceipt() — it inherits the default version.
}
