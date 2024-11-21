package chapter03;

import mypackage.Goods2;

public class Goods2App {
	public static void main(String[] args) {
		Goods2 goods2 = new Goods2();
		
		// 접근제한 없음
		goods2.name = "camera";
		
		// 같은 패키지
		// 자식 접근 가능
		// goods2.price = 10000;
		
		// 같은 패키지
		// goods2.countStock = 10;
		
		// 내부 접근만 가능
//		goods2.countSold = 20;
	}
}
