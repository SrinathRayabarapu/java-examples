package com.book.tij.rtti;

public class WildCardClassReferences {
	
	public static void main(String[] args) {
		//any type - wild card implementation
		Class<?> intClass = int.class;
		
		//it's almost same but first one is preferred
		Class intClass1 = int.class;
	}
}