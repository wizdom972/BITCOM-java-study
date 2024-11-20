package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액: ");
		int money = scanner.nextInt();

		for (int m : MONEYS) {
			System.out.println(m + "원 : " + money / m + "개");
			
			money -= ((money / m) * m);
		}

		scanner.close();
	}
}