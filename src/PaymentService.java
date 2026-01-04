public class PaymentService {

    public boolean processPayment(Payment payment, PaymentProcessor processor) {

        System.out.println("Starting payment processing...");

        payment.setStatus(PaymentStatus.PROCESSING);

        boolean result = processor.processPayment(payment);

        if (!result) {
            payment.setStatus(PaymentStatus.FAILED);
        }

        return result;
    }
}
