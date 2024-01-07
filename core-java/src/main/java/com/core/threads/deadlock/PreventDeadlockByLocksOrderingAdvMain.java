package com.core.threads.deadlock;

/**
 * Ways of avoiding Deadlocks:<br/>
 * -> Consistent ordering of lock acquisition helps avoid deadlocks (Current Example)<br/>
 * -> Using timeouts for lock acquisition can help avoiding deadlocks
 *
 * If more than one lock has to be obtained in more than one thread, It is better to obtain locks in the same
 * sequence to avoid deadlocks. Deadlocks are very hard to detect.
 *
 * @author Srinath.Rayabarapu
 */
public class PreventDeadlockByLocksOrderingAdvMain {

	static public void main(String[] args) throws Exception {

		Object train = new Object();
		Object compartment = new Object();

		// passing train and compartment objects in the same order is important
		Thread t1 = new CancelTicket1(train, compartment);
		Thread t2 = new BookTicket1(train, compartment);

		// we are now spinning off two threads one for booking a ticket and other for cancelling ticket
		t1.start();
		t2.start();
	}

}

class CancelTicket1 extends Thread {

	private Object train, comp;

	public CancelTicket1(Object train, Object comp) {
		this.train = train;
		this.comp = comp;
	}

	public void run() {
		// grab lock on comp
		synchronized (comp) {
			System.out.println(" cancel ticket grabbed lock on comp");
			try {
				sleep(5000);
			} catch (Exception e) {
			}
			System.out.println("  cancel ticket  now trying to grab lock on train");
			synchronized (train) {
				System.out.println("  cancel ticket  grabbed lock on train");
			}
		}
	}
}

class BookTicket1 extends Thread {

	Object train, comp;

	public BookTicket1(Object train, Object comp) {
		this.train = train;
		this.comp = comp;
	}

	public void run() {
		// grab lock on train
		synchronized (comp) {
			System.out.println("  book ticket  grabbed lock on comp");
			try {
				sleep(5000);
			} catch (Exception e) {
			}
			System.out.println("  book ticket   now trying to grab lock on train");
			synchronized (train) {
				System.out.println("  book ticket   grabbed lock on train");
			}
		}
	}
}
