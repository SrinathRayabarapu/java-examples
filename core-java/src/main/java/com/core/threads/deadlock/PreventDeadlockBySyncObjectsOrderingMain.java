package com.core.threads.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Ways of avoiding Deadlocks:<br/>
 * -> Consistent ordering of lock acquisition helps avoid deadlocks (Current Example)<br/>
 * -> Using timeouts for lock acquisition can help to avoid deadlocks
 *
 * @author Srinath.Rayabarapu
 */
public class PreventDeadlockBySyncObjectsOrderingMain {
	
	public static void main(String[] args) {
		
		final List<String> namesList = new ArrayList<>();
		final List<String> subjectsList = new ArrayList<>();

		Runnable readNames = () -> {
			//synchronized is a way to acquire lock on Object
			synchronized (namesList) {
				System.out.print("readNames(): Acquired lock on namesList..");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (subjectsList) {
					System.out.println("and lock on subjectsList");
				}
			}
		};
		
		Runnable readSubjects = () -> {
			synchronized (namesList) {	//subjectsList
				System.out.print("readSubjects(): Acquired lock on namesList..");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (subjectsList) { //namesList
					System.out.println("and lock on subjectsList");
				}
			}
		};

		//if we replace the commented values then we will get a Deadlock
		new Thread(readNames).start();
		new Thread(readSubjects).start();

	}
	
}