package orangebeans;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class OrderProcessingTest {

    @Test
    public void ProcessOrderTest(){
        OrderService service = new OrderService();
        Order order = new Order();

        String reference = service.PlaceOrder(order);

        assertThat(reference,is("PR-1"));
    }


}
