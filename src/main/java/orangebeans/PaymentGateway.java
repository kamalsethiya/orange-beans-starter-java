package orangebeans;

public class PaymentGateway {

    public String initiatePayment(float total, int correlationID) {
        return String.valueOf(correlationID);
    }
}
