package com.core.collections;

/**
 * Hashcode related operations
 *
 * @author Srinath.Rayabarapu
 */
public class HashCodeMain {

	public static void main(String[] args) {
		String s1 = "Hello";// These two objects r pointing to the same memory location
		String s2 = "Hello";

		String st1 = new String("Hello");
		String st2 = new String("Hello");

		System.out.println((s1 == s2) + " | " + (s1.equals(s2)) + " | " + s1.hashCode() + " | " + s2.hashCode());
		System.out.println((st1 == st2) + " | " + (st1.equals(st2)) + " | " + st1.hashCode() + " | " + st2.hashCode());
	}

}