package com.dsalgo.arrays.matrix;

public class SubMatrixMaxSum {
	static int[][] arr = {
			{1, 2, 3}, 
			{1, 3 ,6}, 
			{22, 1, 33}
			};
	public static void main(String[] args) {
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
					method1(i, j);
			}
		}
		
	}

	private static void method1(int i, int j) {
		int a = i+1, b = j+1;
		if(a < arr.length || j < arr[0].length){
			
		}
	}
}
