package com.dsalgo.arrays;

/**
 * given an array, find positions of two elements which sum should be equals to given number
 *
 * Time Complexity: O(n^2)
 *
 * TODO - Improve to O(n)
 *
 * @author Srinath.Rayabarapu
 *
 */
public class FindTwoElementPositionsOfGivenSumMain {

	public static void main(String[] args) {

		int[] input = { 1, 4, 9 , 23, 2, 8, 2, 99, 2, 34};
		int sum = 36;

		for(int i=0; i<input.length; i++) {
			for(int j=i; j<input.length; j++) {
				if(input[i] + input[j] == sum) {
					System.out.println("found at : " + i + ", " + j);
				}
			}
		}

	}
}