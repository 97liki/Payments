public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(Payment payment) {
        System.out.println("Processing Card payment...");
        // Example logic: Card always succeeds
        payment.setStatus(PaymentStatus.SUCCESS);
        return true;
    }
}
