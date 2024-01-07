package com.core.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket client program to connect to a server and read input stream
 *
 * @author Srinath.Rayabarapu
 */
public class DailyAdviceSocketClientMain {

	public static void main(String[] args) {
		DailyAdviceSocketClientMain adviceClient = new DailyAdviceSocketClientMain();
		adviceClient.go();
	}

	private void go() {
		try {
			Socket socket = new Socket("127.0.0.1", 4040);
			InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(streamReader);

			String advice = bufferedReader.readLine();
			System.out.println("Advice Guy says : " + advice);

			bufferedReader.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
