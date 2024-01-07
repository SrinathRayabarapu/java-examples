package com.book.tij.rtti;

public class ArrayObjectDemo {
	
	public static void main(String[] args) {
		char[] charArray = "Srinath".toCharArray();
		// primitive types are not Objects
		char c = 'a';
		if(charArray instanceof Object){
			System.out.println("Yes, char array is an instance of Object class");
		}
		System.out.println("charArray.getClass():" + charArray.getClass());
		
	}

}
