package com.core.java8.lambda.references;

import com.core.java8.streams.to.Person;

/**
 * 
 * @author srayabar
 */
public class MethodReferences {
	
	public static void main(String[] args) {
		
		Something something = new Something();

		// object method references
		FindFirster<String, String> find = something::startsWith;
		
		String convert = find.findFirst("ABC");
		System.out.println(convert);

		// constructor references - looks for a constructor which is matching to interface method
		PersonFactory<Person> factory = Person::new;

		//static method references - can use only in case of pass through
		Thread t1 = new Thread(MethodReferences::printMessage);
		t1.start();
		
	}
	
	public static void printMessage() {
		System.out.println("printing");
	}
	
}

class Something{
	String startsWith(String s){
		return String.valueOf(s.charAt(0));
	}
}

interface PersonFactory<P extends Person>{
	P create(String firstName, String lastName);
}

/**
 * functional interface must have exactly one abstract method
 */
@FunctionalInterface //optional
interface FindFirster<F, T>{
	T findFirst(F from);
}

interface FirstName<S>{
	String getName();
}