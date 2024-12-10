package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "192.168.0.123";

	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;

		try {
			sc = new Scanner(System.in);

			// 1. 소켓생성
			socket = new Socket();

			// 2. 서버연결
			socket.connect(new InetSocketAddress(SERVER_IP, 8080));

			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));

			while (true) {
				System.out.print(">>");
				String line = sc.nextLine();

				if ("exit".equals(line)) {
					break;
				}

				pw.println(line);
				String data = br.readLine();

				if (data == null) {
					log("closed by server");
					break;
				}
				System.out.println("<<" + data);
			}

		} catch (SocketException e) {
			log("Socket Exeption: " + e);

		} catch (IOException e) {
			log("error: " + e);

		} finally {
			try {
				if (sc != null) {
					sc.close();
				}

				if (socket != null && !socket.isClosed()) {
					socket.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void log(String message) {
		System.out.println("[Echo Client] " + message + " ");
	}

}
