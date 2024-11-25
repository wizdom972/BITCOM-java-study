package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		//calendar는 싱글톤/팩토리 자바 object 없나???? 아 오브젝트는 최상위지
		//시발 코틀린 쓰고 싶다
		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
		System.out.println(aLocale);
		
		TimeZone tz = TimeZone.getDefault();
		System.out.println(tz);
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		printDate(cal);
		
		
		
	}

	private static void printDate(Calendar cal) {
		
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
	}

}
