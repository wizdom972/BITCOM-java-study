package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	private float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		// protected는 자식 접근 가능
		return discountRate * price;
	}
}
