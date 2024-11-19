package prob05;

public class Sol05 {
	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			int hundred = i / 100;
			int ten = i / 10;
			int one = i % 10;

			int count = 0;

			if (hundred % 3 == 0 && hundred != 0) {
				count++;
			}

			if (ten % 3 == 0 && ten != 0) {
				count++;
			}

			if (one % 3 == 0 && one != 0) {
				count++;
			}

			if (count > 0) {
				System.out.print(i + " ");

				for (int j = 0; j < count; j++) {
					System.out.print("짝");
				}

				System.out.println();
			}
		}

	}
}
