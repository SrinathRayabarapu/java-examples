package com.core.threads.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * thread designed to acquire two monitors
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class CancelTicket extends Thread {

	private final Object train;
	private final Object compartment; //lock objects should be final in order to avoid any misuses

	public CancelTicket(Object compartment, Object train) {
		this.compartment = compartment;
		this.train = train;
	}

	@Override
	public void run() {
		// grab lock on comp
		synchronized (compartment) {
			log.info("grabbed lock on compartment monitor");
			try {
				// some heavy operation
				compartment.wait(5000);
			} catch (Exception ignored) {
				// ignore
			}

			// assume that we are now getting data from server, if cancel ticket is performed very quickly we may
			// not face deadlock, (try removing sleep and see)
			// This is why we say thread programs are difficult to debug .In many cases due to problems with threads
			// whole system hangs.
			log.info("now trying to grab lock on train monitor");
			synchronized (train) {
				log.info("grabbed lock on train");
			}
		}
	}
}
