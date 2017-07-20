package orangebeans;

import orangebeans.models.Order;

public class NotificationService {
    public void notify(Order order) {
        switch (order.getStatus()) {
            case PENDING:
                System.out.println("Order " + order.getId() + " is Pending for Payment");
                break;
            case SHIPPED:
                System.out.println("Order " + order.getId() + " is Shipped");
                break;
            default:
                System.out.println("Order " + order.getId() + " is Accepted");
                break;
        }
    }
}