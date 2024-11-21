package prob02;

import java.util.Scanner;

public class GoodsTest {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			String[] info = scanner.nextLine().split(" ");

			String name = info[0];
			int price = Integer.parseInt(info[1]);
			int stockCount = Integer.parseInt(info[2]);

			Goods newGoods = new Goods(name, price, stockCount);
			goods[i] = newGoods;
		}

		// 상품 출력
		for (Goods g : goods) {
			g.printInfo();
		}

		scanner.close();
	}
}