public class Main {

    public static void main(String[] args) {

        PaymentService service = new PaymentService();
        PaymentProcessor upiProcessor = new UpiPaymentProcessor();

        Payment payment1 = new Payment("P1", 200, "K1");
        Payment payment2 = new Payment("P2", 400, "K2");
        Payment payment3 = new Payment("P3", 600, "K3");

        service.processPayment(payment1, upiProcessor);
        service.processPayment(payment2, upiProcessor);
        service.processPayment(payment3, upiProcessor);

        System.out.println("\nALL PAYMENTS:");
        for (Payment p : service.getAllPayments()) {
            p.printDetails();
        }

        System.out.println("\nSUCCESS PAYMENTS:");
        for (Payment p : service.getPaymentsByStatus(PaymentStatus.SUCCESS)) {
            p.printDetails();
        }
    }
}
