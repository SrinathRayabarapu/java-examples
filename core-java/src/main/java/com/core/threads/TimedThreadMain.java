package com.core.threads;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimedThreadMain {
	
	public static void main(String[] args) {
		new Thread(new TimedThread()).start();
	}

}

class TimedThread implements Runnable{
	
	private GregorianCalendar mCalendar = new GregorianCalendar();
	
	@Override
	public void run() {
		
		while (true) {
			System.out.println("printing");
			try{
	        	Thread.sleep(getTime());
	        }catch(InterruptedException inex) {
	        	continue;
	        }
		}		
	}
	
	private long getTime() {
		
		this.mCalendar.setTime(new Date());
		this.mCalendar.add(Calendar.SECOND, 2);
		/*
		mCalendar.set(Calendar.HOUR_OF_DAY, 0);
		mCalendar.set(Calendar.MINUTE, 0);
		mCalendar.set(Calendar.SECOND, 2);
		mCalendar.set(Calendar.MILLISECOND, 0);
		if ((mCalendar.getTime().getTime() - System.currentTimeMillis()) <= 0)
			mCalendar.add(Calendar.DAY_OF_MONTH, 0);
		*/
		
		return this.mCalendar.getTime().getTime() - System.currentTimeMillis();		
	}
}