package orangebeans;


import orangebeans.models.Order;
import orangebeans.models.OrderStatus;
import orangebeans.repo.OrderRepository;

public class OrderService {
    PaymentService paymentService = new PaymentService();
    private OrderRepository orderRepository;
    private FulfillmentService fulfillmentService;
    private NotificationService notificationService;

    public OrderService() {
        orderRepository = new OrderRepository();
        notificationService = new NotificationService();
        fulfillmentService = new FulfillmentService(orderRepository);
    }

    public String placeOrder(Order order) {
        order.setStatus(OrderStatus.ACCEPTED);
        Order savedOrder = orderRepository.saveOrder(order);
        savedOrder.setPaymentReference(paymentService.processPayment(savedOrder));
        orderRepository.updateOrder(savedOrder);
        notificationService.notify(savedOrder);
        return savedOrder.getPaymentReference();
    }

    public String completeOrder(String paymentReference) {
        Order order = orderRepository.getOrderByPaymentReference(paymentReference);
        order.setStatus(OrderStatus.PENDING);
        orderRepository.updateOrder(order);
        notificationService.notify(order);
        return fulfillmentService.fulfillOrder(order);
    }

}
