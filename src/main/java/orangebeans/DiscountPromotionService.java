package orangebeans;

import orangebeans.models.Order;
import orangebeans.models.Product;
import orangebeans.models.Promotion;

public class DiscountPromotionService implements PromotionService {

	public void applyPromotion(Order order, Product product) {
		final Promotion promotion = product.getPromotion();
		final Integer percentPromotion = promotion.getOffer();
		final float price = product.getPrice();
		if (percentPromotion < 0 || percentPromotion > 100) {
			throw new IllegalArgumentException("Percent Promotion must be in [0,100]");
		}
		Double priceFactor = (100 - percentPromotion) / 100.0;
		product.setPrice((float) (priceFactor * price));
	}
}
