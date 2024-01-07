package com.core.java8.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * passing code implementation as parameter is crux of Functional Interface
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class FunctionalInterfaceMain {
	
	public static void main(String[] args) {
		
		//traditional way of working : prior to Java 8
		carryOutWork(new SimpleFunctionalInterface() {
			@Override
			public void doWork() {
				log.info("Works in traditional way too!");
			}
		});
		
		//lambda way of working
		// doWork method doesn't take a params
		SimpleFunctionalInterface sf1 = () -> log.info("Works in Lambda!");
		sf1.doWork();
		sf1.defaultMethod();

	}
	
	public static void carryOutWork(SimpleFunctionalInterface sfi) {
		sfi.defaultMethod();
		sfi.doWork();
	}
}

/**
 * annotation is to help compiler, without that also can be treated as functional interface.
 */
@FunctionalInterface
interface SimpleFunctionalInterface	{

	// a default method is accepted here since it's already implemented!
	default void defaultMethod(){
		System.out.println("Hey.. I'm default method!");
	}

	void doWork();
}