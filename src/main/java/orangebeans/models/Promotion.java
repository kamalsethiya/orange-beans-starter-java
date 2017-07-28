package orangebeans.models;

public class Promotion {

	private PromotionType promotionType;

	private Integer offer;

	public Promotion(PromotionType promotionType, Integer offer) {
		this.promotionType = promotionType;
		this.offer = offer;
	}

	/**
	 * @return the promotionType
	 */
	public PromotionType getPromotionType() {
		return promotionType;
	}

	/**
	 * @return the offer
	 */
	public Integer getOffer() {
		return offer;
	}
}
