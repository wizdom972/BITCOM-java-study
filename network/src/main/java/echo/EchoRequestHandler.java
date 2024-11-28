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

public class EchoRequestHandler extends Thread {
	private Socket socket;

	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			// 4. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 보조 스트림 + 알아서 버퍼 비워줄까?
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));

			while (true) {
				// 5. 데이터 읽기
				String data = br.readLine();

				if (data == null) {
					// closed by client
					EchoServer.log("closed by client");
					break;
				}

				EchoServer.log("receive:" + data);
				// 6. 데이터 쓰기
				pw.println(data);
			}
		} catch (SocketException e) {
			EchoServer.log("Socket error:" + e);

		} catch (IOException e) {
			EchoServer.log("error:" + e);

		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
