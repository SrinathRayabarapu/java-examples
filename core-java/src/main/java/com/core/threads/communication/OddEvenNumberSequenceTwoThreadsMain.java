package com.core.threads.communication;

/**
 * program to inter-thread communication for printing event and odd numbers on each thread
 * Note: Can be achieved same with single thread with even/odd number print logic
 *
 * Note: prints till count specified
 *
 * #siemens #wallmartlabs
 *
 * @author Srinath.Rayabarapu
 */
public class OddEvenNumberSequenceTwoThreadsMain {
	
	public static void main(String[] args) {

		//common lock for both threads
		Object lock = new Object();
		int count = 10;

		Thread thread1 = new Thread(new OddNumberThread(lock, count));
		Thread thread2 = new Thread(new EventNumberThread(lock, count));

		thread1.start();
		//to make sure thread2 starts only after thread1 with 1 sec delay
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
	}

}

/*
 * thread to print odd numbers
 */
class OddNumberThread implements Runnable{

	private int counter = 1;
	private final Object lock;
	private int count;

	public OddNumberThread(Object lock, int count) {
		this.lock = lock;
		this.count = count;
	}

	@Override
	public void run() {
		synchronized (this.lock) {
			while(this.counter < this.count){
				System.out.println("Thread-1 : "+this.counter);
				try {
					//first notify then wait
					this.lock.notifyAll();
					this.lock.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.counter = this.counter + 2;
			}
			this.lock.notifyAll();
		}
	}
}

/*
 * thread to print event numbers
 */
class EventNumberThread implements Runnable{

	private int counter = 2;
	private final Object lock;
	private int count;

	public EventNumberThread(Object lock, int count) {
		this.lock = lock;
		this.count = count;
	}

	@Override
	public void run() {
		synchronized (this.lock) {
			while(this.counter <= this.count){
				System.out.println("Thread-2 : "+this.counter);
				try {
					//first notify then wait
					this.lock.notifyAll();
					this.lock.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.counter = this.counter + 2;
			}
		}
	}

}