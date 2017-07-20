package orangebeans;

import orangebeans.models.Order;
import orangebeans.models.OrderStatus;
import orangebeans.repo.OrderRepository;

public class FulfillmentService
{
    ShippingService shippingService = new ShippingService();
    NotificationService notificationService = new NotificationService();
    private OrderRepository orderRepository;

    public FulfillmentService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public String fulfillOrder(Order order)
    {
        order.setStatus(OrderStatus.SHIPPED);
        order.setTrackingID(shippingService.sendShipment(order));
        orderRepository.updateOrder(order);
        notificationService.notify(order);

        return order.getTrackingID();
    }
}