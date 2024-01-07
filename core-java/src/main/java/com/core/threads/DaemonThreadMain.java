package com.core.threads;

/**
 * Daemon thread used for running a task in the background and it doesn't block the main thread termination
 */
public class DaemonThreadMain {
	public static void main(String[] args) {
		DaemonThread d = new DaemonThread();
		Thread t = new Thread(d);
		t.setDaemon(true);
		t.start();
		System.out.println("ExitingMain");
	}
}

class DaemonThread implements Runnable {
	public void run() {
		for (int i = 0; i < 20; i++)
			System.out.println("DaemonThread :" + i);
	}
}
