package com.core.threads;

public class WaitingForThread {
	public static void main(String[] args) {
		System.out.println("before");
		
		Thread instance = RunnableThread.getInstance();
		instance.start();
		
		//custom way
		/*while(true){
			if(RunnableThread.isPassed){
				break;
			}
		}*/

		Thread instance1 = RunnableThreadExtn.getInstance();
		instance1.start();
		
		/*
		//using an API
		try {
			instance.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		System.out.println("done");
	}
}

class RunnableThread extends Thread {
	
	static boolean isPassed = false;
	static Thread myself = new RunnableThread();
	
	static Thread getInstance(){
		return myself;
	}
	
	public void run() {
		System.out.println("RunnableThread Thread running..");
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isPassed = true;
	};
}



class RunnableThreadExtn extends Thread {
	
	static boolean isPassed = false;
	static Thread myself = new RunnableThreadExtn();
	
	static Thread getInstance(){
		return myself;
	}
	
	public void run() {
		System.out.println("RunnableThreadExtn Thread running..");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(RunnableThread.getInstance().isAlive());
		
		isPassed = true;
	};
}
