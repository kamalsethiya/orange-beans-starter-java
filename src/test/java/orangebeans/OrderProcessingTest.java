package orangebeans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import orangebeans.models.Order;
import orangebeans.models.Product;
import orangebeans.models.Promotion;
import orangebeans.models.PromotionType;

import org.junit.Test;

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

	@Test
	public void ProcessDiscountOrderTest() {
		OrderService service = new OrderService();
		Order order = new Order();
		Product product = new Product("T-Shirt", 100);
		product.setPromotion(new Promotion(PromotionType.DISCOUNT_PERCENTAGE, 10));
		order.getProducts().put(product, 1);

		service.placeOrder(order);

		assertThat(product.getPrice(), is(90f));
	}

	@Test(expected = IllegalArgumentException.class)
	public void ProcessInvalidDiscountOrderTest() {
		OrderService service = new OrderService();
		Order order = new Order();
		Product product = new Product("T-Shirt", 100);
		product.setPromotion(new Promotion(PromotionType.DISCOUNT_PERCENTAGE, 101));
		order.getProducts().put(product, 1);

		service.placeOrder(order);
	}

	@Test
	public void ProcessBOGOOrderTest() {
		OrderService service = new OrderService();
		Order order = new Order();
		Product product = new Product("T-Shirt", 100);
		product.setPromotion(new Promotion(PromotionType.BOGO, 1));
		order.getProducts().put(product, 2);

		service.placeOrder(order);

		assertThat(product.getPrice(), is(50f));
	}

	@Test(expected = RuntimeException.class)
	public void ProcessInvalidBOGOOrderTest() {
		OrderService service = new OrderService();
		Order order = new Order();
		Product product = new Product("T-Shirt", 100);
		product.setPromotion(new Promotion(PromotionType.BOGO, 1));
		order.getProducts().put(product, 1);

		service.placeOrder(order);
	}
	
	@Test
	public void ProcessOrderWithoutOfferTest() {
		OrderService service = new OrderService();
		Order order = new Order();
		Product product = new Product("T-Shirt", 100);
		order.getProducts().put(product, 1);

		service.placeOrder(order);

		assertThat(product.getPrice(), is(100f));
	}
}