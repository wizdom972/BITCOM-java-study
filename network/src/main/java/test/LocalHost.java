package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			System.out.println(hostName);
			
			String hostIPAddress = inetAddress.getHostAddress();
			System.out.println(hostIPAddress);
			
			byte[] IPAddress = inetAddress.getAddress();
			for (byte b : IPAddress) {
				System.out.print(b& 0x000000ff);
			}
			System.out.println();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
