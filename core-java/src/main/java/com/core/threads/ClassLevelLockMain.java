package com.core.threads;

/**
 * even though multiple threads are called internally they depend on static object or .class to achieve
 * class level lock
 *
 * @author Srinath.Rayabarapu
 */
public class ClassLevelLockMain {
	public static void main(String[] args) {
		new ClassLevelLock("srinath");
		new ClassLevelLock("chaitu");
		new ClassLevelLock("raghav");
	}
}

class ClassLevelLock implements Runnable {

	// class level locking
	private static final Object OBJECT = new Object();

	Thread thread;
	String name;

	public ClassLevelLock(String name) {
		this.name = name;
		thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run() {
		// or can use ClassLevelLock.class
		synchronized (OBJECT) {
			System.out.println("--------" + name + " Accessing --------");
			try {
				Thread.sleep(5000); //blocking thread for 5 sec
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
