package com.dsalgo.arrays.matrix;

public class UnevenMatrix {
	public static void main(String[] args) {
		int a[][] = new int[4][];
		int k = 1;
		for (int i = 0; i < 4; i++) {
			a[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				a[i][j] = k;
				k++;
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(a[i][j] + "\t ");
			}
			System.out.println();
		}
	}

}
