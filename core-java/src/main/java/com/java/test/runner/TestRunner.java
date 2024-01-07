package com.java.test.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
	public static void main(String[] args) {
		Result runClassesResult = JUnitCore.runClasses(
				JUnitAnnotation.class
				);
		
		for(Failure failure : runClassesResult.getFailures()){
			System.out.println(failure.toString());
		}
		
		System.out.println("Is Successful : " + runClassesResult.wasSuccessful());		
	}
}