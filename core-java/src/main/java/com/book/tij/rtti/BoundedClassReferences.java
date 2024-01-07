package com.book.tij.rtti;

public class BoundedClassReferences {
	public static void main(String[] args) {
		
		//accepts all objects which extends Number class
		Class<? extends Number> extNumberClass = int.class;
		
		//OK
		extNumberClass = double.class;
		
		//OK
		extNumberClass = long.class;
		
		// NOT OK!
		//extNumberClass = String.class;
	}
}
