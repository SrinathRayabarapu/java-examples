package com.core.threads.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * If a thread already holds the lock on a monitor object, it has access to all blocks synchronized on the same monitor object. 
 * This is called re-entrance. The thread can re-enter any block of code for which it already holds the lock.
 * 
 * @author Srinath.Rayabarapu
 */
public class ReentrantLockThreadDemo {
	
	public static void main(String[] args) {
		//passing same object to two thread here is important, else we may not observe reentrant lock behaviour
		Thread t1 = new Thread(() -> accessResource(), "T1"); //method reference, good practice!
		Thread t2 = new Thread(() -> accessResource(), "T2"); //lambda, alternate way - just for learning

		t1.start();
		t2.start();
	}

	private static void accessResource() {
		Lock lock = new ReentrantLock();

		System.out.println(Thread.currentThread().getName() + ": 1");

		try {
			lock.lock();
			lock.lock();
			lock.lock();

			int holdCount = ((ReentrantLock) lock).getHoldCount();
			System.out.println(holdCount);
			// performing some shared resource operation
			System.out.println(Thread.currentThread().getName() + ": 2");
			System.out.println(Thread.currentThread().getName() + ": 3");

		} finally {
			lock.unlock(); //always put unlock in finally block, this helps in case of any exceptions
			lock.unlock();
			lock.unlock(); //make sure unlock() called same number of times of lock()
		}
	}

}