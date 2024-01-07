package com.core.threads;

public class ThreadDemo {

	public void even() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	public void odd() {
		for (int i = 1; i < 100; i += 2) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		ThreadDemo obj = new ThreadDemo();
		obj.even();
		new childThread(obj).start();

	}
}

class childThread implements Runnable {
	Thread t;
	ThreadDemo obj;

	public childThread(ThreadDemo obj) {
		this.obj = obj;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		obj.odd();
	}
	
	public void start() {
		System.out.println("Hi...");
	}
}
