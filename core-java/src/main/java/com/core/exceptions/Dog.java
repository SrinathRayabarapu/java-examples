package com.core.exceptions;

public class Dog {
	public void play() {
		System.out.println("dog plays with you....");
	}

	public void disturb(String s) throws DogBiteException {
		if (s.equals("badman")) {
			throw new DogBiteException(
					"you have troubled me, now enjoy the bite...");
		} else if (s.equals("goodman")) {
			System.out.println("let me forgive you once....");
		}
	}
}
