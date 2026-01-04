public class Main {

    public static void main(String[] args) {

        Payment payment = new Payment("PAY123", 500.0);

        PaymentProcessor processor = new UpiPaymentProcessor();

        PaymentService service = new PaymentService();

        boolean result = service.processPayment(payment, processor);

        payment.printDetails();
        System.out.println("Payment success: " + result);
    }
}
