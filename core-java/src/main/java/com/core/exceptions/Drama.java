package com.core.exceptions;

public class Drama {
	public static void main(String[] args) {
		Dog tiger = new Dog();

		tiger.play();
		try {
			tiger.disturb("badman");
		} catch (DogBiteException de) {
			System.out.println(de);
		}
		System.out.println("happy days.......");
	}
}
