package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {

	public static void main(String[] args) {
		Socket socket = null;

		try {
			// 1. 소켓생성
			socket = new Socket();
			
			// 1-1. 소켓 버퍼 사이즈
			int rcvBufferSize = socket.getReceiveBufferSize();
			int sndBufferSize = socket.getSendBufferSize();
			
			System.out.println(rcvBufferSize + ":" + sndBufferSize);

			// 2. 서버연결
			socket.connect(new InetSocketAddress("192.168.0.10", 60000));
			
			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			// 4. 쓰기
			String data = "Hello World";
			os.write(data.getBytes("utf-8"));
			
			// 5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			if (readByteCount == -1) {
				System.out.println("[client] closed by server");
				return;
			}
			
			data = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println("[client] received: " + data);
		} catch (SocketException e) {
			System.out.println("[client] Socket Exeption: " + e);
			
		} catch (IOException e) {
			System.out.println("[Client] error: " + e);
			
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
