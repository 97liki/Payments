public class Payment {

    private String paymentId;
    private double amount;
    private PaymentStatus status;
    private String idempotencyKey;

    public Payment(String paymentId, double amount, String idempotencyKey) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.idempotencyKey = idempotencyKey;
        this.status = PaymentStatus.CREATED;
    }

    public void printDetails() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Amount: " + amount);
        System.out.println("Status: " + status);
        System.out.println("Idempotency Key: " + idempotencyKey);
    }

    public void setStatus(PaymentStatus newStatus) {

        if (this.status == PaymentStatus.SUCCESS || this.status == PaymentStatus.FAILED) {
            throw new InvalidPaymentStateException(
                    "Cannot change status from " + this.status);
        }

        this.status = newStatus;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

}
