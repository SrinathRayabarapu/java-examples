package com.util;

/* 13.	A lottery requires that you select six different numbers from the integers 1 to 49. Write a program to do this for you and generate five sets of entries. */

class GenerateRandom {
	int num;

	GenerateRandom() {
		super();
	}

	void randoms() {
		for (int j = 1; j <= 5; j++) {
			System.out.println("SET NO. " + j);
			for (int i = 1; i <= 6; i++) {
				num = 1 + (int) (49 * Math.random());
				System.out.print("  " + num);
			}
			System.out.println();
		}
	}
}

class RandomTest {
	public static void main(String args[]) {
		GenerateRandom gr = new GenerateRandom();
		gr.randoms();
	}
}
