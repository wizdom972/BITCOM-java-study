package behaivoral.observer;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Subject<Integer> intSubject = new Subject<Integer>();
		intSubject.registerObserver(new Observer<Integer>() {
			
			@Override
			public void update(Integer val) {
				// TODO Auto-generated method stub
				
			}
		});
		
		intSubject.registerObserver((Integer val) -> {
			System.out.println("observer02: " + val);
		});
		
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			Integer val = sc.nextInt();
			intSubject.changeSubject(val);
		}
	}

}
