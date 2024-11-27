package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = sc.nextLine();
		
		try {
			InetAddress[] addresses = InetAddress.getAllByName(host);
			
			for (InetAddress inetAddress : addresses) {
				System.out.println(host + " : " + inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
