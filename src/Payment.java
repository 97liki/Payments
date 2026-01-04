public class Payment {

    private String paymentId;
    private double amount;
    private PaymentStatus status;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = PaymentStatus.CREATED;
    }

    public void printDetails() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Amount: " + amount);
        System.out.println("Status: " + status);
    }

    public void setStatus(PaymentStatus newStatus) {

        if (this.status == PaymentStatus.SUCCESS || this.status == PaymentStatus.FAILED) {
            throw new InvalidPaymentStateException(
                    "Cannot change status from " + this.status);
        }

        this.status = newStatus;
    }

}
