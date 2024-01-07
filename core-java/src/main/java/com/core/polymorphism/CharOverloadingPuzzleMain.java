package com.core.polymorphism;

/**
 * characters are inherently their ASCII integer represantations - so they matches to integers easily.
 *
 * @author Srinath.Rayabarapu
 */
public class CharOverloadingPuzzleMain {
	
	static void myMethod(int i) {
		System.out.println("int version");
	}
	
	void myMethod(String s) {System.out.println("String version");}
	
	public static void main(String[] args) {
		char ch = 'c';
		myMethod(ch); //matches to int version as char values are referred integers internally
	}
}