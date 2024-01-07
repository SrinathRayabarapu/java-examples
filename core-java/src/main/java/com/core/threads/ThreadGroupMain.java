package com.core.threads;

/**
 * Threadgroups are useful to set the priority
 */
public class ThreadGroupMain {
	public static void main(String[] args) throws Exception {

		// way to get your current thread group and see all of its parent groups
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		threadGroup.setMaxPriority(8);

		// adding thread to a threadgroup
		Thread taskThread = new Thread(threadGroup, new MyTask(), "MyTaskThread");
		taskThread.start();

		while(threadGroup.getParent() != null){
			threadGroup = threadGroup.getParent();
		}
		threadGroup.list();

	}
}

class MyTask implements Runnable{
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}