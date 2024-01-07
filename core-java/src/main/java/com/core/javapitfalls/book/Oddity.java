package com.core.javapitfalls.book;

public class Oddity {

	public static void main(String[] args) {
		System.out.println(isOdd(10));
		
		System.out.println(isOdd(11));
		
		System.out.println(isOdd(17267326));
		
		System.out.println(isOdd(132323));
		
		System.out.println(isOdd(-1));
		
		System.out.println(isOdd(-2));
		
		System.out.println(isOdd1(-1));
		
		System.out.println(isOdd1(-19));
	}
		
	public static boolean isOdd(int i){
		System.out.println(i%2);
		return i%2 == 1;
	}	
	
	public static boolean isOdd1(int i){
		return i%2 != 0;
	}
	
	public static boolean isOdd2(int i){
		return (i & 1) != 0;
	}
	
}