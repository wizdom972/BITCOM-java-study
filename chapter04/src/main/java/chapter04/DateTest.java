package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		
		System.out.println(now);
		
		printDate01(now);
		printDate02(now);
		
	}

	private static void printDate02(Date now) {
		// + 1900 해줘야함
		int year = now.getYear();
		
		// 0 ~ 11, +1 해줘야함
		int month = now.getMonth();
	}

	private static void printDate01(Date now) {
		// 2024-11-25 14:23:30
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(now);
		
		System.out.println(date);
	}
}
