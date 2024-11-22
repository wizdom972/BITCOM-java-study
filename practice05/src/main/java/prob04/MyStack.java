package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		buffer = new String[capacity];
		top = 0;
	}

	public void push(String s) {
		if (top >= buffer.length) {
			resize();
		}
		
		buffer[top] = s;
		top++;
	}

	public String pop() throws MyStackException {
		if (top > 0) {
			return buffer[--top];
		} else {
			throw new MyStackException();
		}
	}

	public boolean isEmpty() {
		return top == 0;
	}

	private void resize() {
		String[] temp = new String[top + 1];
		System.arraycopy(buffer, 0, temp, 0, buffer.length);
		
		buffer = temp;
	}	
}