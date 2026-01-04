public class WalletPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(Payment payment) {
        System.out.println("Processing Wallet payment...");
        // Example logic: Wallet has 50% chance of failure
        if (Math.random() > 0.5) {
            payment.setStatus(PaymentStatus.SUCCESS);
            return true;
        } else {
            payment.setStatus(PaymentStatus.FAILED);
            return false;
        }
    }
}
