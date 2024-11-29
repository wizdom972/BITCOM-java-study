package httpd;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

import javax.print.Doc;

public class RequestHandler extends Thread {
	private Socket socket;
	private final String DOCUMENT_ROOT = "./webapp";

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			String request = null;

			while (true) {
				String line = br.readLine();

				// 브라우저가 연결을 끊으면
				if (line == null) {
					break;
				}

				// SimpleHttpServer는 HTTP Header만 읽는다.
				if ("".equals(line)) {
					break;
				}

				// Request Header의 첫 줄만 읽기
				if (request == null) {
					request = line;
					break;
				}
			}

			consoleLog(request);
			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				responseStaticResources(outputStream, tokens[1], tokens[2]);

			} else {
				// methods: POST, DELETE, PUT, HEAD, CONNECT, ...
				// 여기서는 무시(400 Bad Request)
				outputStream.write("HTTP/1.1 400 Bad Request\r\n".getBytes("UTF-8"));
				outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes("UTF-8"));
				outputStream.write("\r\n".getBytes());
				outputStream.write("<h1>400 Bad Request</h1>".getBytes("UTF-8"));
			}

		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void responseStaticResources(OutputStream os, String url, String protocol) throws IOException {
		if ("/".equals(url)) {
			url = "/index.html";
		}

		File file = new File(DOCUMENT_ROOT + url);
		if (!file.exists()) {
			// 404 response
			os.write("HTTP/1.1 404 Not Found\r\n".getBytes("UTF-8"));
			os.write("Content-Type: text/html; charset=utf-8\r\n".getBytes("UTF-8"));
			os.write("\r\n".getBytes());
			os.write("<h1>404 Not Found</h1>".getBytes("UTF-8"));
			return;
		}

		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		os.write((protocol + " 200 OK\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);

	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
