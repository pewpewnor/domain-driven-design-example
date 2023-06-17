package PaymentManagement.factory;

import PaymentManagement.model.Payment;

public class PaymentFactory {
    public static Payment createPayment(String currency, double balance) {
        return new Payment(currency, balance);
    }
}