package com.dsalgo.arrays.matrix;

/**
	To rotate a ring, we need to do following.
    1) Move elements of top row.
    2) Move elements of last column.
    3) Move elements of bottom row.
    4) Move elements of first column.
	Repeat above steps for inner ring while there is an inner ring.
	<p>
	Note: This doesn't require a new matrix - it's a in-place movement algorithm

 * @author srayabar
 */
public class MatrixRotationClockwiseMain {
	
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 34, 2, 4 }, 
						{ 12, 13, 14, 4,6,7 }, 
						{ 11, 16, 15, 4, 5,8 },
						{ 10, 9, 8, 1, 2, 55 } 
			  		  };
		rotatematrix(arr.length, arr[0].length, arr);
	}
	
	/*
	int arr[][] = { { 1, 2, 3, 34, 2, 4 }, 
					{ 12, 13, 14, 4,6,7 }, 
					{ 11, 16, 15, 4, 5,8 },
					{ 10, 9, 8, 1, 2, 55 } 
				  };
	 */

	// A function to rotate a matrix mat[][] of size R x C.
	// Initially, m = R and n = C
	static void rotatematrix(int endRow, int endCol, int[][] matrix)
	{
		int rows = matrix.length, columns =matrix[0].length;
	    int startRow = 0, startCol = 0;
	    int prev, curr;

	    /*
	       srow - Staring row index
	       erow - ending row index
	       scol - starting column index
	       ecol - ending column index
	       i - iterator
	    */
	    while (startRow < endRow && startCol < endCol)
	    {
	    	//case 1 - only one element matrix
	        if (startRow + 1 == endRow || startCol + 1 == endCol)
	            break;

	        // Store the first element of next row, this element will replace first element of current row
	        prev = matrix[startRow + 1][startCol];

	         /* Move elements of first row from the remaining rows */
	        for (int i = startCol; i < endCol; i++)
	        {
	            curr = matrix[startRow][i];
	            matrix[startRow][i] = prev;
	            prev = curr;
	        }
	        startRow++;

	        /* Move elements of last column from the remaining columns */
	        for (int i = startRow; i < endRow; i++)
	        {
	            curr = matrix[i][endCol-1];
	            matrix[i][endCol-1] = prev;
	            prev = curr;
	        }
	        endCol--;
	 
	         /* Move elements of last row from the remaining rows */
	        if (startRow < endRow)
	        {
	            for (int i = endCol-1; i >= startCol; i--)
	            {
	                curr = matrix[endRow-1][i];
	                matrix[endRow-1][i] = prev;
	                prev = curr;
	            }
	        }
	        endRow--;

	        /* Move elements of first column from the remaining rows */
	        if (startCol < endCol)
	        {
	            for (int i = endRow-1; i >= startRow; i--)
	            {
	                curr = matrix[i][startCol];
	                matrix[i][startCol] = prev;
	                prev = curr;
	            }
	        }
	        startCol++;
	    }

	    // Print rotated matrix
	    for (int i=0; i<rows; i++)
	    {
	        for (int j=0; j<columns; j++){
		          System.out.print(matrix[i][j]+ " ");
	        }
	        System.out.println("");
	    }
	}	
}