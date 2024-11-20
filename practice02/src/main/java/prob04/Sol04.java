package prob04;

public class Sol04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		int len = str.length();

		char[] charArray = new char[len];

		for (int i = charArray.length - 1; i >= 0; i--) {
			charArray[i] = str.charAt(charArray.length - i - 1);
		}

		return charArray;
	}

	public static void printCharArray(char[] array) {
		for (char c : array) {
			System.out.print(c);
		}
		
		System.out.println();
	}
}