public class Main {

    public static void main(String[] args) {

        // Create payments
        Payment payment1 = new Payment("PAY123", 500.0);
        Payment payment2 = new Payment("PAY124", 1500.0);
        Payment payment3 = new Payment("PAY125", 300.0);

        // Assign processors dynamically
        PaymentProcessor upiProcessor = new UpiPaymentProcessor();
        PaymentProcessor cardProcessor = new CardPaymentProcessor();
        PaymentProcessor walletProcessor = new WalletPaymentProcessor();

        // Process each payment
        processAndPrint(payment1, upiProcessor);
        processAndPrint(payment2, cardProcessor);
        processAndPrint(payment3, walletProcessor);
    }

    // Helper method to reduce repeated code
    public static void processAndPrint(Payment payment, PaymentProcessor processor) {
        boolean result = processor.processPayment(payment);
        payment.printDetails();
        System.out.println("Payment success: " + result);
        System.out.println("---------------------------");
    }
}
