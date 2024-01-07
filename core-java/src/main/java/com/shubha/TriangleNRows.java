package com.shubha;

public class TriangleNRows {

	public static void main(String[] args) {

		int n = 5;// given
		int seq = 1;
		// old way
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(seq + " ");
				seq++;
			}
			System.out.print("\n");
		}		
	}
}