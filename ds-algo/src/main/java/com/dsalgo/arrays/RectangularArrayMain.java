package com.dsalgo.arrays;

/**
 * print a 4*4 integer matrix.
 *
 * @author Srinath.Rayabarapu
 */
public class RectangularArrayMain {

	public static void main(String args[]) {

		int a[][] = new int[4][4];
		int k = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				a[i][j] = k;
				k++;
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(a[i][j] + "\t ");
			}
			System.out.println();
		}

	}
}
