package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("12321323");
		System.out.println("12321323");

		if (1 - 1 == 0) {
			throw new MyException();
		}
		
		
		if (1 - 1 == 0) {
			throw new IOException();
		}

		System.out.println("12321323");
		System.out.println("12321323");

	}
}
