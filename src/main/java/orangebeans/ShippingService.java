package orangebeans;

import orangebeans.models.Order;

public class ShippingService {

    public String sendShipment(Order order) {
        return "TR-" + String.valueOf(order.getId());
    }
}