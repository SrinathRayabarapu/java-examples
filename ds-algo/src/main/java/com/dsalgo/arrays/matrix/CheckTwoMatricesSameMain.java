package com.dsalgo.arrays.matrix;

/**
 * given two matrices of same number of rows and columns - find whether they are equal or not
 * 
 * @author srayabar
 *
 */
public class CheckTwoMatricesSameMain {

	public static void main(String[] args) {
		int[][] a1 = {{1, 2, 3},{4, 5, 6},{7, 8, 9},{10, 11, 12}};
		int[][] a2 = {{1, 2, 3},{4, 5, 9},{7, 8, 9},{10, 11, 12}};
		
		int counter = 0;
		for(int i=0;i<a1.length; i++){
			for(int j=0;j<a1[i].length; j++){
				if(a1[i][j] == a2[i][j]){
					counter ++;
				}
			}
		}
		System.out.println(counter);
	}
}
