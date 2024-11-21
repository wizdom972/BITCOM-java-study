package mypackage;

public class Goods2 {
	// 모두 접근 가능
	public String name;
	// 같은 패키지 + 자식 클래스
	protected int price;
	// 클래스 내부에서만 접근 가능
	private int countSold;
	// 같은 패키지에서만(default)
	int countStock;
	
	public void m() {
		// private은 내부만 접근 가능
		countStock = 10;
	}
}
