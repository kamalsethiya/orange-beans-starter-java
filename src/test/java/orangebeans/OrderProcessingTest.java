package orangebeans;

import orangebeans.models.Order;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class OrderProcessingTest {

    @Test
    public void ProcessOrderTest() {
        OrderService service = new OrderService();
        Order order = new Order();

        String reference = service.placeOrder(order);

        assertThat(reference, is("PR-1"));
    }

    @Test
    public void CompleteOrderTest() {
        OrderService service = new OrderService();
        Order order = new Order();

        String reference = service.placeOrder(order);
        String trackingID = service.completeOrder(reference);

        assertThat(trackingID, is("TR-1"));
    }
}