package com.core.threads;

class Callme {
	
	public synchronized void call(String message) {
		System.out.println(message);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("interrupted");
		}
	}
	
}

class Caller implements Runnable {
	
	String message;
	ThreadsSyncWithJoin target;
	Thread t;

	public Caller(ThreadsSyncWithJoin target, String message) {
		this.message = message;
		this.target = target;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		synchronized (target) {
			target.call(message);
		}
	}

}

public class ThreadsSyncWithJoin {
	
	public static void main(String[] args) {
		
		ThreadsSyncWithJoin target = new ThreadsSyncWithJoin();
		Caller c1 = new Caller(target, "hi");
		Caller c2 = new Caller(target, "hello");
		Caller c3 = new Caller(target, "synchronized");

		try {
			c1.t.join();
			c2.t.join();
			c3.t.join();
		} catch (InterruptedException ie) {
			System.out.println("interrupted");
		}
		
		System.out.println(ThreadsSyncWithJoin.class.getName() + " is exited");
	}

	public void call(String message) {
		new Callme().call(message);
	}
	
}