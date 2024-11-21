package prob04;

public class StringUtil {
	public static String concatenate(String[] strArray) {
		String result = "";
		
		for (String string : strArray) {
			result += string;
		}
		
		return result;
	}


}
