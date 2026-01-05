public class PaymentWorker extends Thread {

    private PaymentService service;
    private Payment payment;
    private PaymentProcessor processor;

    public PaymentWorker(PaymentService service, Payment payment, PaymentProcessor processor) {
        this.service = service;
        this.payment = payment;
        this.processor = processor;
    }

    @Override
    public void run() {
        service.processPayment(payment, processor);
    }
}
