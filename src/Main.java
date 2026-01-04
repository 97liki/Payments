public class Main {

    public static void main(String[] args) {

        Payment payment = new Payment("PAY123", 500.0);

        PaymentProcessor processor = new UpiPaymentProcessor();

        boolean result = processor.processPayment(payment);

        payment.printDetails();
        System.out.println("Payment success: " + result);
    }
}
