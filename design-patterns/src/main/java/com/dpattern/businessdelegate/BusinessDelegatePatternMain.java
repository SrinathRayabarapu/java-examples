package com.dpattern.businessdelegate;

/**
 * The Business Delegate acts as a client-side business abstraction, it provides an abstraction for, and thus hides, 
 * the implementation of the business services. It reduces the coupling between presentation-tier clients and the system's Business services.
 * 
 * https://www.geeksforgeeks.org/business-delegate-pattern/
 * 
 * @author Srinath.Rayabarapu
 */
public class BusinessDelegatePatternMain {

	public static void main(String[] args) {
		
		BusinessDelegate businessDelegate = new BusinessDelegate();

		businessDelegate.setService("police");
		Client client = new Client(businessDelegate);
		System.out.println("Asking to do task : ");
		client.doTask();
		
		businessDelegate.setService("doctor");
		client = new Client(businessDelegate);
		System.out.println("Asking to do task : ");
		client.doTask();
	}
	
}