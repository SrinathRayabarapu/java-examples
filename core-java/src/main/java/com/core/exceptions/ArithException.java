package com.core.exceptions;

/* 27.	Write a program that calls a method which throws an exception of type Arithmetic Exception at a random iteration in a for loop. Catch the exception in the method and pass the iteration count when the exception occurred to the calling method, by using an object of an exception class you define */

class Except1 {
	int count = 0;
	int i, a, b, c;

	void randomLoop() {
		for (i = 1; i <= 10; i++) {

			a = 0 + (int) (10 * Math.random());
			try {
				b = (int) (i / a);
				count++;
			}

			catch (Exception ex) {
				
				//Class<? extends Exception> class1 = ex.getClass();
				
				
				System.out.println(ex.getMessage());
				System.out.println(ex.getClass().getName());
			}
		}
	}

	int returnCount() {
		return count;
	}
}

class ArithException {
	public static void main(String[] args) {
		Except1 e1 = new Except1();
		try {
			e1.randomLoop();
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
		}
		// System.out.println("Loop count "+e1.returnCount());
	}
}
