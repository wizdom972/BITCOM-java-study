package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// 여기다 소켓생성 하래

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				System.out.println("clicked");

//				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();

				if (keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		// 1. 서버 연결 작업
		// 2. IO Stream set
		// 3. join protocol
		// 4. ChatClientThread 생성

	}

	private void sendMessage() {

		String message = textField.getText();
		// 메시지 보내는 프로토콜 구현

		textField.setText("");
		textField.requestFocus();
		
		// ChatClientThread에서 서버로 부터 받은 메세지가 있다면
		// 스레드에 가있어야하는 코드
		updateTextArea(message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		// quit 프로토콜 구현
		
		// exit java app
		System.exit(0);
	}

	private class ChatClientThread extends Thread {

		@Override
		public void run() {
			updateTextArea("asdfsdf");
		}
		
	}
}
