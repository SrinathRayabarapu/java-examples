package com.dsalgo.arrays.triangle;

/**
 * print two inverted * triangles which looks like sand timer.
 *
 * @author Srinath.Rayabarapu
 */
public class PrintSandTimerTrianglesMain {

	public static void main(String[] args) {
		PrintSandTimerTrianglesMain.printTestTriangle(10);
	}

	public static void printFullTriangle(int number) {

		for (int i = 0; i < number; i++) {
			for (int k = number; k > i; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	public static void printInvertedFullTriangle(int number) {

		for (int i = number; i > 0; i--) {
			for (int j = number; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = i; k > 0; k--) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	public static void printTwoInvertedTriangle(int number) {

		for (int i = 0; i < number; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = number; k > i; k--) {
				System.out.print("..");
			}
			for (int m = 0; m <= i; m++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

	public static void printTestTriangle(int number) {

		for (int i = number; i > 0; i--) {
			for (int j = number; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = i; k > 0; k--) {
				System.out.print("* ");
			}
			System.out.println("");
		}

		number = number++;

		for (int i = 0; i < number; i++) {
			for (int k = number; k > i; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

}