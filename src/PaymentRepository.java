import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {

    private Map<String, Payment> paymentStore = new HashMap<>();
    private Map<String, String> processedKeys = new HashMap<>();

    public void save(Payment payment) {
        paymentStore.put(payment.getPaymentId(), payment);
        processedKeys.put(payment.getIdempotencyKey(), payment.getPaymentId());
    }

    public boolean isAlreadyProcessed(String key) {
        return processedKeys.containsKey(key);
    }

    public Payment findById(String paymentId) {
        return paymentStore.get(paymentId);
    }
}
