package com.core.polymorphism;

/**
 * Overloading puzzle
 *
 * Method overloading means having two or more methods with the same name but different signatures
 * in the same scope with same or different return types
 *
 * @author Srinath.Rayabarapu
 */
public class OverloadingPuzzleMain {
	
	void add(String str) {
		System.out.println(str);
	}

	void add(Object obj) {
		System.out.println("obj");
	}
	
	public static void main(String[] args) {
		new OverloadingPuzzleMain().add(null);
	}
}