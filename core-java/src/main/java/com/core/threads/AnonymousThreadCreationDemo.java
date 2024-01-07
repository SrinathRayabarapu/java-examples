package com.core.threads;

/**
 * an anonymous way to create a thread from both Thread class and Runnable interface.
 * 
 * @author srayabar
 */
public class AnonymousThreadCreationDemo {
	
    /**
     * @param args
     */
	public static void main(String[] args) {
		
		//from Thread class
        Thread t1 = new Thread() { // this is anonymous class code
			public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("MyThread :" + i);
                }
			}
		};
		t1.start();
		
		//from Runnable interface - by passing it to Thread constructors
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("MyThread :" + i);
                }
			}
		});
		t2.start();
	}
}
