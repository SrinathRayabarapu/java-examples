package com.core.threads.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * a simple runnable class which when called prints it's name and sleeps for finite time
 * 
 * @author srayabar
 *
 */
public class TaskThread implements Runnable{
	
	private String name;
	
	public TaskThread(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public void run() {
		System.out.println("Running Task : " + this.name);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}