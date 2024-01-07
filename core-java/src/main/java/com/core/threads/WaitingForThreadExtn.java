package com.core.threads;

public class WaitingForThreadExtn {
	
	public static void main(String[] args) {
		System.out.println(RunnableThread.getInstance().getState());
		System.out.println(RunnableThread.getInstance().isAlive());
	}

}
