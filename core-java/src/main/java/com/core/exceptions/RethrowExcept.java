package com.core.exceptions;

/* 26.	Add an exception class to the previous example that will differentiate between the index-out-of-bounds error possibilities, rethrow an appropriate object of this exception class in divide( ) and handle the exception in main( ).*/

class ExceptHand {
	public static void main(String[] v) {
		Exception1 e1 = new Exception1();

		try {
			e1.divide();

		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("hye");
		}

	}
}

class Exception1 {
	int arr2[] = new int[10];

	void divide() {
		try {
			for (int i = 0; i <= 10; i++)
				arr2[i] = i + 1;

			for (int i = 0; i < 10; i++)
				System.out.println(arr2[i]);

		} catch (ArrayIndexOutOfBoundsException ae1) {
			throw ae1;
		}
	}
}