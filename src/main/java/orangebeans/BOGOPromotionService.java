package orangebeans;

import orangebeans.models.Order;
import orangebeans.models.Product;
import orangebeans.models.Promotion;

public class BOGOPromotionService implements PromotionService {

	public void applyPromotion(Order order, Product product) {
		final Promotion promotion = product.getPromotion();
		final Integer offer = promotion.getOffer();
		if (offer != null) {
			final Integer integer = order.getProducts().get(product);
			if (integer % 2 != 0) {
				throw new RuntimeException("Add one more product of type : " + product.getName() + " to avail BOGO.");
			} else {
				product.setPrice(product.getPrice() / 2);
			}
		}
	}
}