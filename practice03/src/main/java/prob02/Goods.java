package prob02;

public class Goods {
	private String name;
	private int price;
	private int stockCount;

	public Goods(String name, int price, int stockCount) {
		this.name = name;
		this.price = price;
		this.stockCount = stockCount;
	}

	public void printInfo() {
		System.out.println(name + "(가격:" + price + "원)이 " + stockCount + "개 입고 되었습니다.");
	}
}