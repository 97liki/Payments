public class PaymentService {

    private PaymentRepository repository = new PaymentRepository();

    public boolean processPayment(Payment payment, PaymentProcessor processor) {

        try {
            payment.setStatus(PaymentStatus.PROCESSING);

            boolean result = processor.processPayment(payment);

            if (!result) {
                payment.setStatus(PaymentStatus.FAILED);
            }

            repository.save(payment); // 👈 store payment

            return result;

        } catch (InvalidPaymentStateException ex) {
            System.out.println("Payment error: " + ex.getMessage());
            return false;
        }
    }

    public Payment getPayment(String paymentId) {
        return repository.findById(paymentId);
    }
}
