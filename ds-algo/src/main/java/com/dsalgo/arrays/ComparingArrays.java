package com.dsalgo.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * checking two arrays whether equal or not with equals() method
 * 
 * @author Sreekanth
 */
public class ComparingArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] int1 = new int[5];
		int[] int2 = new int[5];

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("Please enter first array elements ");

		try {
			for (int i = 0; i < int1.length; i++) {
				int1[i] = Integer.parseInt(bufferedReader.readLine());
			}

			System.out.println("Please enter Second array elements ");
			for (int i = 0; i < int2.length; i++) {
				int2[i] = Integer.parseInt(bufferedReader.readLine());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Boolean boolean1 = Arrays.equals(int1, int2);

		if (boolean1 == true) {
			System.out.println("Both arrays are equal");
		} else
			System.out.println("Both arrays not are equal");
	}
}
