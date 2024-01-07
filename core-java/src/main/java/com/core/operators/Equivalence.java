package com.core.operators;

public class Equivalence {

	public static void main(String[] args) {

		Integer n1 = new Integer(47);
		Integer n2 = new Integer(47);

		// checking only references, not the values
		System.out.println(n1 == n2);
		System.out.println(n1 != n2);

		// checks actual content, so its true
		System.out.println(n1.equals(n2));

		int N = 10;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N - i; j++)
				System.out.print(" .");

			for (int j = 0; j < i; j++)
				System.out.print("* ");

			for (int j = 0; j < i; j++)
				System.out.print("* ");

			System.out.println();
		}
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < i; j++)
				System.out.print(" .");

			for (int j = 0; j < N - i; j++)
				System.out.print("* ");

			for (int j = 0; j < N - i; j++)
				System.out.print("* ");

			System.out.println();
		}
	}
}
