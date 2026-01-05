import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {

    private Map<String, Payment> paymentStore = new HashMap<>();

    public void save(Payment payment) {
        paymentStore.put(payment.getPaymentId(), payment);
    }

    public Payment findById(String paymentId) {
        return paymentStore.get(paymentId);
    }
}
