package com.dpattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstrates the Singleton Design Pattern - one of the Gang of Four (GoF) Creational patterns.
 * 
 * <p>The Singleton pattern restricts instantiation of a class to a single instance and provides
 * a global access point to that instance. This is useful when exactly one object is needed
 * to coordinate actions across the system.</p>
 * 
 * <h3>Key Characteristics:</h3>
 * <ul>
 *   <li>Private constructor to prevent direct instantiation</li>
 *   <li>Private static instance variable</li>
 *   <li>Public static method to get the instance</li>
 * </ul>
 * 
 * <h3>Common Use Cases:</h3>
 * <ul>
 *   <li><b>Logging</b> - Single logger instance across application</li>
 *   <li><b>Configuration</b> - Application-wide settings</li>
 *   <li><b>Connection Pools</b> - Database connection management</li>
 *   <li><b>Thread Pools</b> - Shared thread execution service</li>
 *   <li><b>Caching</b> - Centralized cache management</li>
 *   <li><b>Device Drivers</b> - Hardware access coordination</li>
 * </ul>
 * 
 * <h3>Implementations Demonstrated:</h3>
 * <ul>
 *   <li>{@link SingletonCommon} - Basic lazy initialization (not thread-safe)</li>
 *   <li>{@link SingletonEager} - Eager initialization (thread-safe)</li>
 *   <li>{@link BillPughSinglePattern} - Inner class holder (recommended, thread-safe)</li>
 * </ul>
 * 
 * <h3>Thread Safety Considerations:</h3>
 * <p>Naive implementations are not thread-safe. Solutions include:</p>
 * <ul>
 *   <li>Eager initialization</li>
 *   <li>Synchronized getInstance() method</li>
 *   <li>Double-checked locking with volatile</li>
 *   <li>Bill Pugh's inner class holder pattern</li>
 *   <li>Enum-based singleton (most robust)</li>
 * </ul>
 * 
 * @author Srinath.Rayabarapu
 * @see SingletonCommon
 * @see SingletonEager
 * @see BillPughSinglePattern
 */
@Slf4j
public class SingletonPatternMain {

	/**
	 * Demonstrates different Singleton implementations and verifies
	 * that multiple calls return the same instance.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		
		SingletonCommon s1 = SingletonCommon.getInstance();
		SingletonCommon s2 = SingletonCommon.getInstance();
		log.info("SingletonCommon s1 : " + s1);
		log.info("SingletonCommon s2 : " + s2);


		// java.lang packages classes use this
		SingletonEager blockSingleton1 = SingletonEager.getInstance();
		SingletonEager blockSingleton2 = SingletonEager.getInstance();
		log.info("SingletonEager blockSingleton1 : " + blockSingleton1);
		log.info("SingletonEager blockSingleton2 : " + blockSingleton2);


		//  using inner class
		BillPughSinglePattern pattern1 = BillPughSinglePattern.getInstance();
		BillPughSinglePattern pattern2 = BillPughSinglePattern.getInstance();
		log.info("BillPughSinglePattern pattern1 : " + pattern1.hashCode());
		log.info("BillPughSinglePattern pattern2 : " +pattern2.hashCode());

	}

}

