package orangebeans;

import orangebeans.models.Order;
import orangebeans.models.Product;

public class PaymentService {

    PaymentGateway gateway = new PaymentGateway();

    public String processPayment(Order order) {
        float total = 0;


        for (Product product : order.getProducts().keySet()) {
            int quantity = order.getProducts().get(product);
            total += product.getPrice() * quantity;
        }

        return "PR-" + gateway.initiatePayment(total, order.getId());
    }
}