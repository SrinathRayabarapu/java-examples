package com.core.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * to understand f.i capability to pass on behalf of comparators and print conditions
 * 
 * @author srayabar
 *
 */
public class FunctionalInterfaceCollectionsSort {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		
		System.out.println("Before - "+ names);
		
		Collections.sort(names, new Comparator<String>() {//old way of doing
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		
		System.out.println("After - " + names);
		
		
		System.out.println("-------------");
		
		
		List<String> namesList = Arrays.asList("pet", "ana", "ike", "xia");
		
		System.out.println("Before - " + namesList);
		
		Collections.sort(namesList, (String s1, String s2) -> {//java 8 way of doing - using lambdas
			return s1.compareTo(s2);
		});
		
		// alternative 1
		Collections.sort(namesList, (String s1, String s2) -> s1.compareTo(s2)); //one lines don't need to return
		
		//alternative 2
		Collections.sort(namesList, (s1, s2) -> s1.compareTo(s2)); //jvm knows the return type
		
		System.out.println("After - " + namesList);
		
		System.out.println("Prinitng Conditionally now-------------");
		
		//second parameter matches to Condition interface as it has single method only
		printConditionally(namesList, s -> s.startsWith("a"));
		
	}

	/*
	private static void printConditionally(List<String> namesList, Condition condition) {
		for (String string : namesList) {
			if(condition.test(string)) {
				System.out.println(string);
			}
		}
	}
	*/
	
	/**
	 * this works because Predicate FI has an abstract method test
	 * 
	 * @param namesList
	 * @param predicate
	 */
	private static void printConditionally(List<String> namesList, Predicate<String> predicate) {
		for (String string : namesList) {
			if(predicate.test(string)) {
				System.out.println(string);
			}
		}
	}

}

interface Condition{
	boolean test(String str);
}