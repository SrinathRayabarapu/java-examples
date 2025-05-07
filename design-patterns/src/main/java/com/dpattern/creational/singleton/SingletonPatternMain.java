package com.dpattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * -> One of the Gangs of Four Design patterns <-
 *
 * SingletonCommon pattern restricts the instantiation of a class and ensures that only one instance of the
 * class exists in the java virtual machine. The singleton class must provide a global access point to get 
 * the instance of the class. SingletonCommon pattern is used for logging, drivers objects, caching and thread pool.
 * <p>
 * Practical usecases: Cache, DB Connection, Logger, Configuration Manager, Thread Pool, Device drivers etc.
 * <p>
 * https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
 * 
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class SingletonPatternMain {

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

