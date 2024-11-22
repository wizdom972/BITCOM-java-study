package exception;

public class MyException extends Exception {
	public MyException() {
		super("MyExecption");
	}
	
	public MyException(String m) {
		super(m);
	}
}
