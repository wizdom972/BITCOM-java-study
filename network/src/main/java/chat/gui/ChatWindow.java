package chat.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import chat.ChatClient;

public class ChatWindow {

    private Frame frame;
    private Panel panel;
    private Button buttonSend;
    private TextField textField;
    private TextArea textArea;

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String name;
    
	Encoder encode = Base64.getEncoder();
	Decoder decode = Base64.getDecoder();

    public ChatWindow(String name) {
        this.name = name;
        frame = new Frame(name);
        panel = new Panel();
        buttonSend = new Button("Send");
        textField = new TextField();
        textArea = new TextArea(30, 80);
    }

    public void show() {
        // 버튼 설정
        buttonSend.setBackground(Color.GRAY);
        buttonSend.setForeground(Color.WHITE);
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sendMessage();
            }
        });

        // 텍스트 필드 설정
        textField.setColumns(80);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        // 패널 설정
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(textField);
        panel.add(buttonSend);
        frame.add(BorderLayout.SOUTH, panel);

        // 텍스트 영역 설정
        textArea.setEditable(false);
        frame.add(BorderLayout.CENTER, textArea);

        // 프레임 설정
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                finish();
            }
        });

        frame.setVisible(true);
        frame.pack();

        // 서버 연결 및 스레드 시작
        connectToServer();
        new ChatClientThread().start();
    }

    private void connectToServer() {
        try {
            socket = new Socket("192.168.0.10", 12020); // 서버 IP와 포트를 설정
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

            // 서버에 join 프로토콜 전송
            writer.println("join:" + name);
        } catch (IOException e) {
            updateTextArea("서버 연결 실패: " + e.getMessage());
        }
    }

    private void sendMessage() {
        String message = textField.getText();
        if (message.isEmpty()) return;
        
        byte[] encodeByte = encode.encode((name + ":" + message).getBytes());

        writer.println("message:" + new String(encodeByte)); // 서버로 메시지 전송
        textField.setText("");
        textField.requestFocus();
    }

    private void updateTextArea(String message) {
        textArea.append(message + "\n");
    }

    private void finish() {
        try {
            // quit 프로토콜 전송
            if (writer != null) {
                writer.println("quit:" + name);
            }
            // 소켓 종료
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            updateTextArea("종료 중 오류 발생: " + e.getMessage());
        }
        System.exit(0);
    }

    private class ChatClientThread extends Thread {
        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                	// 4. 프로토콜 분석
    				String[] tokens = message.split(":");

    				if ("join".equals(tokens[0])) {
    					if ("ok".equals(tokens[1])) {
    						updateTextArea("채팅방에 입장하였습니다.");
    						continue;
    					}
    					
    					updateTextArea(tokens[1]);

    				} else if ("message".equals(tokens[0])) {    					
    					byte[] decodeByte = decode.decode(tokens[1]);
    					String decodeString = new String(decodeByte);

    					String[] data = decodeString.split(":");
    					String nickname = data[0];
    					String m = data[1];

    					updateTextArea(nickname + ": " + m);

    				} else if ("quit".equals(tokens[0])) {
    					updateTextArea(tokens[1]);
    				} else {
    					ChatClient.log("에러: 알수 없는 요청 (" + tokens[0] + ")");
    				}
                }
            } catch (IOException e) {
                updateTextArea("서버 연결 종료");
            }
        }
    }
}
