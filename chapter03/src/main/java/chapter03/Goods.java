package chapter03;

public class Goods {

	public static int countOfGoods = 0;

	private String name;
	private int price;
	private int countStock;
	private int countSold;

	public Goods() {
		countOfGoods++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void printInfo() {
		System.out.println("상품이름: " + name);
		System.out.println("가격: " + price);
		System.out.println("재고개수: " + countStock);
		System.out.println("팔린 개수: " + countSold);
	}

	public float clacDiscountPrice(float discountRate) {
		float result = price - price * discountRate;
		
		return result;
	}
}
