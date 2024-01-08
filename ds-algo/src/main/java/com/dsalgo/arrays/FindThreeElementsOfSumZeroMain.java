package com.dsalgo.arrays;

/**
 * find combinations of three elements whose sum is 0.
 *
 * Time Complexity: O(n^3)
 *
 * @author Srinath.Rayabarapu
 */
public class FindThreeElementsOfSumZeroMain {
	
	public static void main(String[] args) {
		
		int[] input = {-1, 0, 1, 2, -1, -4};
		
		for(int i=0; i+2< input.length; i++) {
			for(int j=i+1; j<input.length; j++) {
				for(int k=i+2; k<input.length; k++) {
					if(input[i] + input[j] + input[k] == 0) {
						System.out.println("found at " + input[i] + ", "+ input[j] + ", " + input[k]);
					}
				}
			}
		}
		
	}

}