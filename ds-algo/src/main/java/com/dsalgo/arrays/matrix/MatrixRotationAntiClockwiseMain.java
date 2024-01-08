package com.dsalgo.arrays.matrix;

/**
 * program to rotate a matrix anti-clock wise direction
 * 
 * @author srayabar
 *
 */
public class MatrixRotationAntiClockwiseMain {
	
	public static void main(String[] args) {
		
		int inputArray[][] ={ 	{ 1, 2, 3, 34, 2, 4 }, 
								{ 12, 13, 14, 4,6,7 }, 
								{ 11, 16, 15, 4, 5,8 },
								{ 10, 9, 8, 1, 2, 55 } 
	  		  				};
		
		rotateAntiClockwiseMatrix(inputArray.length, inputArray[0].length, inputArray);
	}
	
	//anti-clock wise direction : one element movement at a time
	private static void rotateAntiClockwiseMatrix(int endRow, int endCol, int[][] inputMatrix) {
		
		int startRow = 0, startCol = 0;
		int matrixRows = inputMatrix.length, matrixCols = inputMatrix[0].length;
		int prev = 0, curr = 0;
		
		System.out.println("Given matrix:");
		// Print rotated matrix
	    for (int i=0; i<matrixRows; i++)
	    {
	        for (int j=0; j<matrixCols; j++){
		          System.out.print(inputMatrix[i][j]+ " ");
	        }
	        System.out.println("");
	    }
		
	    //check all the matrix layers till the condition
		while(startRow < endRow && startCol < endCol){
			
			//single element matrix
			if(startRow+1 == endRow || startCol+1 == endCol){
				break;
			}
			
			//store the previous element
			prev = inputMatrix[startRow+1][endCol-1];

			//move first row elements
			for(int i=endCol-1; i >= startCol; i--){
				curr = inputMatrix[startRow][i];
				inputMatrix[startRow][i] = prev;
				prev = curr;
			}
			startRow++;
			
			//move last column elements
			for(int i=endRow-1; i >= startRow; i--){
				curr = inputMatrix[i][endCol-1];
				inputMatrix[i][endCol-1] = prev;
				prev = curr;
			}
			endCol--;
			
			//move last row elements
			if(startRow < endRow){
				for(int i=startCol; i<= endCol; i++){
					curr = inputMatrix[endRow-1][i];
					inputMatrix[endRow-1][i] = prev;
					prev = curr;
				}
				endRow--;
			}
			
			//move first column elements
			if(startCol < endCol){
				for(int i=startRow; i<=endRow; i++){
					curr = inputMatrix[i][startCol];
					inputMatrix[i][startCol] = prev;
					prev = curr;
				}
				startCol++;
			}
			
		}//while ends
		
		System.out.println("Rotated matrix:");
		// Print rotated matrix
	    for (int i=0; i<matrixRows; i++)
	    {
	        for (int j=0; j<matrixCols; j++){
		          System.out.print(inputMatrix[i][j]+ " ");
	        }
	        System.out.println("");
	    }	
	}
}