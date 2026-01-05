import java.util.Comparator;

public class PaymentIdComparator implements Comparator<Payment> {

    @Override
    public int compare(Payment p1, Payment p2) {
        return p1.getPaymentId().compareTo(p2.getPaymentId());
    }
}
