package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "192.168.0.10";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, 12020));

			// 4. reader/writer 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			printWriter.println("join:" + nickname);
			printWriter.flush();

			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					break;
				} else if("".equals(input)) {
					System.out.println();
					continue;
				} else {
					// 9. 메시지 처리
					String message = bufferedReader.readLine();
					
					//base 64로 인코딩 하기
					printWriter.println("message:" + message);
				}
			}

		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			// 10. 자원정리
			try {
				if (scanner != null) {
					scanner.close();
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

	private static void log(String message) {
		System.out.println("[Chat client] " + message + " ");

	}

}
