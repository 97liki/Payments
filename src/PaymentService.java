import java.util.Collections;
import java.util.List;

public class PaymentService {

    private PaymentRepository repository = new PaymentRepository();

    public boolean processPayment(Payment payment, PaymentProcessor processor) {

        if (repository.isAlreadyProcessed(payment.getIdempotencyKey())) {
            System.out.println("Duplicate payment request detected. Skipping processing.");
            return true;
        }

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

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return repository.findByStatus(status);
    }

    public List<Payment> getPaymentsSortedByAmount() {
        List<Payment> payments = repository.findAll();
        Collections.sort(payments); // uses compareTo()
        return payments;
    }

    public List<Payment> getPaymentsSortedById() {
        List<Payment> payments = repository.findAll();
        Collections.sort(payments, new PaymentIdComparator());
        return payments;
    }
}
