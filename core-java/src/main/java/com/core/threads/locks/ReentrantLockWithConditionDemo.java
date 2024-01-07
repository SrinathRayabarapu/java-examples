package com.core.threads.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * program to demo reentrant lock and condition for thread synchronization - alternative to wait and notify
 * 
 * @author Srinath.Rayabarapu
 */
public class ReentrantLockWithConditionDemo {

	public static void main(String[] args) {
		
		Runner runner = new Runner();
		
		Thread t1 = new Thread(runner::firstThread);
		Thread t2 = new Thread(runner::secondThread);
		t1.start();
		t2.start();
		
		try {
			// main thread will wait till below threads die
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		runner.finished();
	}
}

/**
 * class which increments counter with two methods
 */
class Runner {

	private int counter = 0;

	//can lock more than once - need unlock with same number of times
	private ReentrantLock lock = new ReentrantLock();

	//get a condition from lock
	private Condition condition = this.lock.newCondition();
	
	//sometimes below two thread methods can interleave counter, pushing it to unknown results - we need locks to avoid this
	private void increment(){
		this.counter = this.counter + 100;
	}
	
	public void firstThread() {

		//when locks are used - no need of synchronized methods/blocks (locks are alternative actually!)
		this.lock.lock();
		
		//as good as Object wait method
		try{
			this.condition.await();
			increment();
			System.out.println("wait is over");
			System.out.println("firstThread(): Incremented!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{ // in order to avoid any exceptions!
			this.lock.unlock();
		}
	}
	
	public void secondThread(){
		//when locks are used - no need of synchronized methods/blocks
		this.lock.lock();
		
		//as good as Object notify method
		this.condition.signal();
		System.out.println("signalled");
		try{
			increment();
			System.out.println("secondThread(): Incremented!");
		}finally{ //good practice
			this.lock.unlock();
		}
	}
	
	public void finished(){
		System.out.println("finished - "+this.counter);
	}
}