package com.core.threads.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPoolExecutorsExample {
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		TaskThread task;
		for(int i=0; i<=5; i++){
			task = new TaskThread("Task" + i);
			System.out.println("New task added : " + task.getName());
			executor.execute(task);			
		}
		executor.shutdown();
	}	
	
}
