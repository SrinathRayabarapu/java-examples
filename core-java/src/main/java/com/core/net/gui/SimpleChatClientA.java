package com.core.net.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleChatClientA {

	JTextField outGoing;
	PrintWriter printWriter;
	Socket socket;

	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}

	private void go() {
		JFrame frame = new JFrame("Easy Chat Client");
		JPanel panel = new JPanel();
		outGoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		panel.add(outGoing);
		panel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		setUpNetworking();
		frame.setSize(400, 500);
		frame.setVisible(true);
	}

	private void setUpNetworking() {
		try {
			socket = new Socket("127.0.0.1", 4040);
			printWriter = new PrintWriter(socket.getOutputStream());
			System.out.println("Network Established");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class SendButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(outGoing.getText());
			printWriter.println(outGoing.getText());
			printWriter.flush();
			outGoing.setText("");
			outGoing.requestFocus();
		}
	}
}