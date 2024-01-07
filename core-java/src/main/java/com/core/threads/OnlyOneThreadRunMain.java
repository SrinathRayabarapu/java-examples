package com.core.threads;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * test program for all adhoc thread concepts testing
 * 
 * @author srayabar
 */
public class OnlyOneThreadRunMain{

	public static void main(String[] args) {
		System.out.println("main method started");
		new TestThread("t1").start();
		new TestThread("t2").start();
	}
}

class TestThread extends Thread {
	
	private String name;
	public TestThread(String str) {
		this.name = str;
	}
	
	private static Object lock = new Object();
	private static AtomicInteger count = new AtomicInteger(0); 
	
	@Override
	public void run() {
		synchronized (lock) {
			if(count.get() == 0) {
				System.out.println("From TestThread - " + name + " - " + new Date().toString());
				count.incrementAndGet();
			} else
				System.out.println("From TestThread - " + name + " - " + "Another thread is already running!!");
		}
	}
	
}