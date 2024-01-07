package com.core.threads;

/**
 * class to demo - how uncaught exceptions can be caught from other threads in main 
 * @author srayabar
 *
 */
public class UncaughtExceptionHandlerDemo {

	public static void main(String[] args) {
		
		//way to handle uncaught exceptions from other threads
		Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Thread " + t.getName() + " throwed exception " + e.getMessage());
			}
		};
		
		//creating an adhoc thread
		Thread thread = new Thread(){
			public void run(){
				//throws unchecked runtime exception
				throw new RuntimeException();
			}
		};
		
		//set the handler
		thread.setUncaughtExceptionHandler(handler);
		
		//start the thread
		thread.start();
	}
}