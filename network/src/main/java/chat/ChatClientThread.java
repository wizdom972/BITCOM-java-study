package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientThread extends Thread {

	private BufferedReader bufferedReader;
	private Socket socket;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
	     /* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */	
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		
			while (true) {
				String request = bufferedReader.readLine();
				if (request == null) {
					ChatServer.log("서버로부터 연결 끊김");
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");

				if ("join".equals(tokens[0])) {
					if ("ok".equals(tokens[1])) {
						System.out.println("채팅방에 입장하였습니다.");
					}

				} else if ("message".equals(tokens[0])) {
					System.out.println(tokens[1]);

				} else if ("quit".equals(tokens[0])) {
					System.out.println(tokens[1]);
					
				} else {
					ChatServer.log("에러: 알수 없는 요청 (" + tokens[0] + ")");
				}
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
