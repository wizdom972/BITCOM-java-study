package chapter04;

public class WrapperClass {

	public static void main(String[] args) {
		// 직접 생성하면 heap상에 객체가 존재
		// 리터럴을 사용하면 JVM안의 Cnstant Pool에서 관리함
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		//auto boxing
		Integer j1 = 10;
		Integer j2 = 20;
		
		//auto unboxing
		int m = j1 + 10;
		//int m = j1.intValue() + 10;
	}
}
