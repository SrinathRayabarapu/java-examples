package com.dsalgo.arrays.matrix;

/**
 * given a 2D matrix, print elements in a spiral fashion
 *
 * @author Srinath Rayabarapu
 */
public class MatrixSpiralTraverseMain {

	public static int matrixTraverse(int arr[][], int row, int column) {

		//printing a row left to right
		for (int k = 0; k < column; k++) {
			System.out.print(" " + arr[0][k]);
		}

		//printing last column across all rows
		for (int k = 1; k < row; k++) {
			System.out.print(" " + arr[k][column - 1]);
		}

		//printing last row from right to left
		for (int k = column - 2; k >= 0; k--) {
			System.out.print(" " + arr[row - 1][k]);
		}

		//printing column from bottom row to top
		for (int k = row - 2; k > 0; k--) {
			System.out.print(" " + arr[k][0]);
		}

		// return the program in case we cann't retrieve a matrix
		if ((row - 2) <= 0) {
			return 0;
		}
		
		int[][] newArr = new int[row - 2][column - 2];
		
		for (int i = 1; i < row - 1; i++) {
            if (column - 1 - 1 >= 0)
                System.arraycopy(arr[i], 1, newArr[i - 1], 0, column - 1 - 1);
		}

		row = newArr.length;
		column = newArr[0].length;
		
		// do the same for remaining matrix
		return matrixTraverse(newArr, row, column);
	}

	public static void main(String args[]) {

		int[][] arr = { { 1, 2, 3, 34, 2, 4 },
						{ 12, 13, 14, 4,6,7 },
						{ 11, 16, 15, 4, 5,8 },
						{ 10, 9, 8, 1, 2, 55 }
					  };

		System.out.println("2D Array : ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print("\t" + arr[i][j]);
			}
			System.out.println();
		}

		System.out.print("Traversed Circular order : \n");
		matrixTraverse(arr, arr.length, arr[0].length);
	}

}