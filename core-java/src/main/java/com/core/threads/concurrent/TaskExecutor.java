package com.core.threads.concurrent;

import java.util.concurrent.BlockingQueue;

public class TaskExecutor implements Runnable	{
	
	BlockingQueue<Runnable> queue;
	
	public TaskExecutor(BlockingQueue<Runnable> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		Runnable task = null;
		try {
			task = this.queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task started by thread - " + name);
		task.run();
		System.out.println("Task finished by thread - " + name);
	}

}