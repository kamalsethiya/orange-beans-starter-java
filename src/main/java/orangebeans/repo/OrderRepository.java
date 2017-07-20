package orangebeans.repo;

import orangebeans.models.Order;

import java.util.HashMap;

public class OrderRepository {

    private HashMap<Integer, Order> orders = new HashMap<Integer, Order>();

    public Order saveOrder(Order order) {
        order.setId(orders.size() + 1);
        orders.put(order.getId(), order);
        return order;
    }

    public void updateOrder(Order savedOrder) {
        orders.put(savedOrder.getId(), savedOrder);
    }

    public Order getOrderByPaymentReference(String paymentReference) {
        return orders.values().stream()
                .filter(o -> o.getPaymentReference() == paymentReference)
                .findFirst().get();
    }
}