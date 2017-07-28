package orangebeans;

import static orangebeans.PromotionFactory.getPromotionService;
import orangebeans.models.Order;
import orangebeans.models.Product;
import orangebeans.models.Promotion;

public final class PromotionProcessor {

	public static void processPromotions(Order order) {

		for (Product product : order.getProducts().keySet()) {
			final Promotion promotion = product.getPromotion();
			if (promotion != null) {
				final PromotionService promotionService = getPromotionService(promotion.getPromotionType());
				promotionService.applyPromotion(order, product);
			}
		}
	}
}