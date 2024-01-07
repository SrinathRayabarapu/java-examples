package com.core.threads;

/**
 * a way to set priority on thread so that it will be given more execution time
 */
public class ThreadsPriorityMain {
	
	static public void main(String[] args) throws Exception {
		Thread copyThread = new Thread(new CopyTask());
		Thread progressThread = new Thread(new ProgressTask());

		// copy thread is given more cpu to execute
		copyThread.setPriority(Thread.MAX_PRIORITY);

		copyThread.start();
		progressThread.start();
	}
}

class CopyTask implements Runnable {
	@Override
	public void run() {
		while (true){
			System.out.print("C");
		}
	}
}

class ProgressTask implements Runnable{
	@Override
	public void run() {
		while (true){
			System.out.print("-");
		}
	}
}