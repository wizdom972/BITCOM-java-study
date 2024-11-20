package prob06;

import java.util.Random;
import java.util.Scanner;

public class Sol06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean gameContinue = true;

		do {
			int count = 1;

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;
			System.out.println(correctNumber);

			System.out.println("수를 결정하였습니다. 맞추어 보세요:");
			System.out.println("1-100");

			while (true) {
				System.out.print(count + ">>");

				int answer = scanner.nextInt();

				if (answer > correctNumber) {
					System.out.println("더 낮게");
					count++;
					continue;
				} else if (answer < correctNumber) {
					System.out.println("더 높게");
					count++;
					continue;
				} else {
					System.out.println("맞췄습니다.");

					// 새 게임 여부 확인하기
					System.out.print("다시 하겠습니까(y/n)>>");
					String answerAgain = scanner.next();
					if ("y".equals(answerAgain) == false) {
						gameContinue = false;
					}
					break;
				}
			}
		} while (gameContinue);

		scanner.close();
	}
}