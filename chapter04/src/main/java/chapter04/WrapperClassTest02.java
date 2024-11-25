package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "12345";
		int i = Integer.parseInt(s);
		
		//cf1. 반대로
		String s2 = String.valueOf(i);
		
		//cf2. 반대로
		String s3 = "" + i;
		
		System.out.println(s + ": " + s2 + ": " + s3);
		
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		//cf ASCII 코드값
		char c = 'A';
		System.out.println((int)c);
		
		//2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		//16진주
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
	}

}
