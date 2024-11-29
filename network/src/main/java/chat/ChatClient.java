package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "192.168.0.10";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		Encoder encode = Base64.getEncoder();

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, 12020));

			// 4. reader/writer 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

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
					printWriter.println("quit:" + nickname);
					break;
				} else if ("".equals(input)) {
					System.out.println();
					continue;
				} else {
					// 9. 메시지 처리
					byte[] encodeByte = encode.encode((nickname + ":" + input).getBytes());

					printWriter.println("message:" + new String(encodeByte));
					printWriter.flush();
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

	public static void log(String message) {
		System.out.println("[Chat client] " + message + " ");

	}

}
