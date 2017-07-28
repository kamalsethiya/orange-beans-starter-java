package orangebeans.util;

import orangebeans.BOGOPromotionService;
import orangebeans.DiscountPromotionService;
import orangebeans.PromotionService;
import orangebeans.models.PromotionType;

public final class PromotionFactory {

	public static PromotionService getPromotionService(final PromotionType promotionType) {
		PromotionService promotionService = null;
		switch (promotionType) {
		case BOGO:
			promotionService = new BOGOPromotionService();
			break;
		case DISCOUNT_PERCENTAGE:
			promotionService = new DiscountPromotionService();
			break;
		}

		return promotionService;
	}
}
