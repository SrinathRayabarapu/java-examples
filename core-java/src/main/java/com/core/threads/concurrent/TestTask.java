package com.core.threads.concurrent;

/**
 * Test thread which would simulate to do some work upon submitting to a Threadpool
 * 
 * @author Srinath.Rayabarapu
 */
public class TestTask implements Runnable{
	
	private int number;
	
	public TestTask(int taskNumber) {
		this.number = taskNumber;
	}
	
	@Override
	public void run() {
		System.out.println("Executing task number - " + this.number);
		try {
			Thread.sleep(1000);//simulating some operation
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
