import java.util.*;

public class PaymentRepository {

    private Map<String, Payment> paymentStore = new HashMap<>();
    private Set<String> processedKeys = new HashSet<>();

    public void save(Payment payment) {
        paymentStore.put(payment.getPaymentId(), payment);
        processedKeys.add(payment.getIdempotencyKey());
    }

    public boolean isAlreadyProcessed(String key) {
        return processedKeys.contains(key);
    }

    public Payment findById(String paymentId) {
        return paymentStore.get(paymentId);
    }

    public List<Payment> findAll() {
        return new ArrayList<>(paymentStore.values());
    }

    public List<Payment> findByStatus(PaymentStatus status) {
        List<Payment> result = new ArrayList<>();

        for (Payment payment : paymentStore.values()) {
            if (payment.getStatus() == status) {
                result.add(payment);
            }
        }
        return result;
    }
}
