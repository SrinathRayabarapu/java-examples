package com.core.threads.locks;

/**
 * Creating a Custom Lock, like ReentrantLock.
 *
 * Impl: have a class with lock and unlock methods. lock method is synchronized and conditionally wait. unlock will notify all threads.
 * 
 * @author Srinath.Rayabarapu
 */
public class CustomLockImplementationDemo {
	
	public static void main(String[] args) {


		// this part works, but not a great code!
		CustomLock lock = new CustomLock();
		System.out.println("before lock");
		try {
			lock.lock();
			System.out.println("after lock");
			lock.unlock();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("after unclock");


		//TODO: thought of testing the way reentrant lock, but failing, need to check later!
		new Thread(() -> accessResource(), "T1").start();
		new Thread(() -> accessResource(), "T2").start();
		
	}

	private static void accessResource(){
		CustomLock lock = new CustomLock();

		try {
			lock.lock();

			// mimicking some operation
			//Thread.sleep(1000);

			System.out.println(Thread.currentThread().getName()+": lock acquired!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println(Thread.currentThread().getName()+": lock released!");
		}
	}

}

/**
 * custom lock class.
 */
class CustomLock {
	
	boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException{
		while(isLocked){ //also called as Spin lock
			wait();
		}
		isLocked = true;
	}
	
	public void unlock(){
		isLocked = false;
		notify();
	}
	
}