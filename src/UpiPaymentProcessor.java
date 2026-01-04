public class UpiPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(Payment payment) {
        System.out.println("Processing UPI payment...");
        payment.setStatus(PaymentStatus.SUCCESS);
        return true;
    }
}
