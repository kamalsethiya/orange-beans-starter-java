package orangebeans.repo;

import java.util.Collection;
import java.util.HashMap;

import orangebeans.models.Order;

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
    	final Collection<Order> values = orders.values();
    	Order orderByPaymentReference = null;
    	for(Order order : values){
    		if(order.getPaymentReference().equalsIgnoreCase(paymentReference)){
    			orderByPaymentReference = order;
    			break;
    		}
    	}
    	return orderByPaymentReference;
		// return orders.values().stream()
		// .filter(o -> o.getPaymentReference() == paymentReference)
		// .findFirst().get();
    }
}