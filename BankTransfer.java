/**
 * IMPLEMENTATION 3: Bank Transfer Payment
 *
 * A third, entirely different mechanism — same contract.
 * This shows the power of interfaces: the store doesn't care HOW
 * payment happens, only that it CAN happen.
 */
public class BankTransfer implements Payable {

    private String bankName;
    private String accountNumber;
    private boolean verified;

    public BankTransfer(String bankName, String accountNumber, boolean verified) {
        this.bankName      = bankName;
        this.accountNumber = accountNumber;
        this.verified      = verified;
    }

    @Override
    public boolean processPayment(double amount) {
        if (!verified) {
            System.out.println("[Bank Transfer] Declined: account not verified.");
            return false;
        }
        if (amount > MAX_TRANSACTION_LIMIT) {
            System.out.println("[Bank Transfer] Declined: exceeds transaction limit.");
            return false;
        }
        System.out.printf("[Bank Transfer] Initiated $%.2f from %s account %s%n",
                          amount, bankName, accountNumber);
        return true;
    }

    @Override
    public String getPaymentSummary() {
        return String.format("Bank Transfer | %s | Acct: %s", bankName, accountNumber);
    }
}
