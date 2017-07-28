package orangebeans;

import orangebeans.models.Order;
import orangebeans.models.Product;

public interface PromotionService {

	void applyPromotion(Order order, Product product);
}
