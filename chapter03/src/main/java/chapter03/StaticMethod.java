package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		StaticMethod.m = 10;
		
		// 같은 클래스의 static 변수 접근에서 클래스 이름 생략가능
	}
	
	void f3() {
		f2();
	}
	
	void b1() {
		
	}
}
