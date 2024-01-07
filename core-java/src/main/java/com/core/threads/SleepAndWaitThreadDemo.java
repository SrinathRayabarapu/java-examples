package com.core.threads;

import java.util.ArrayList;
import java.util.List;

/**
	sleep():
	It is a static method on Thread class. It makes the current thread into the
	"Not Runnable" state for specified amount of time. During this time, the thread
	keeps the lock (monitors) it has acquired.
	<p>
	wait():
	It is a method on Object class. It makes the current thread into the "Not Runnable"
	state. Wait is called on a object, not a thread. Before calling wait() method, the
	object should be synchronized, means the object should be inside synchronized block.
	The call to wait() releases the acquired lock.
	
 * @author srayabar
 *
 */
public class SleepAndWaitThreadDemo {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Started Main");
		TempThread s = new TempThread();
		Thread t1 = new Thread(s, "t1");
		Thread t2 = new Thread(s, "t2");
		t1.start();
		//if called again - throws IllegalThreadStateException
		//t1.start();
		t2.start();
		System.out.println("Exiting Main");
	}
}

class TempThread implements Runnable {
	
	List<String> someList = new ArrayList<String>();
	
	public void run() {
		
		synchronized (someList) {
			try {
				if(Thread.currentThread().getName().equals("t1"))					
					//releases lock for other threads
					someList.wait(); //should be called from synchronized block - means should hold a lock before calling
				
					//hold lock for all the threads - pauses the process
					//Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("thread " + Thread.currentThread().getName());		
	}
}