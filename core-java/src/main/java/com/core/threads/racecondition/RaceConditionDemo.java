package com.core.threads.racecondition;

/**
 * class to demo race condition in multi threading
 *
 * race condition: when two threads are performing an operation on a shared object without any proper
 * synchronization techniques then it will interleave the object to unknown results.
 *
 * Two code patterns where we see race condition issues are:
 * 1. read modify write
 * 2. check and act
 *
 * Below example is of check and act (creating a instance if it's already not present!)
 *
 * Avoiding race condition:
 * 1. keeping the shared object in proper synchronization.
 * 2. for variables, using atomic variables
 *
 * @author Srinath.Rayabarapu
 *
 */
public class RaceConditionDemo {
	
	public static void main(String[] args) throws InterruptedException {
		//ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		
		ConsumerThread consumerThread1 = new ConsumerThread("Thread1");
		ConsumerThread consumerThread2 = new ConsumerThread("Thread2");
		
		Thread thread1 = new Thread(consumerThread1);
		Thread thread2 = new Thread(consumerThread2);
		
		thread1.setPriority(1);
		thread2.setPriority(1);
		
		thread1.start();
		//thread1.join();
		thread2.start();
		
		//executor.submit(consumerThread1);		
		//executor.submit(consumerThread2);		
		//executor.shutdownSessionFactory();
	}
}