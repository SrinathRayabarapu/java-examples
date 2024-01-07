package com.core.threads.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * thread designed to acquire two monitors
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class BookTicket extends Thread {

	private final Object train;
	private final Object comp;

	public BookTicket(Object train, Object comp) {
		this.train = train;
		this.comp = comp;
	}

	@Override
	public void run() {
		// grab lock on train
		synchronized (train) {
			log.info("grabbed lock on train monitor");
			try {
				train.wait(5000); //mimicking some operation
			} catch (Exception ignored) {
				// ignore
			}
			log.info("now trying to grab lock on comp monitor");
			synchronized (comp) {
				log.info("grabbed lock on comp monitor");
			}
		}
	}
}
