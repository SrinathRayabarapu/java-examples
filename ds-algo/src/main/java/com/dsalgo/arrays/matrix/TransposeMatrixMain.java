package com.dsalgo.arrays.matrix;

/**
 * given matrix
 * [[1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9]]
 *
 * transpose it to
 * [[1, 4, 7],
 * [2, 5, 8],
 * [3, 6, 9]]
 *
 * rows to columns vice versa columns to rows
 *
 */
public class TransposeMatrixMain {

    public static void main(String[] args) {
        // hint : matrix[i, j] = matrix[j, i]

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        MatricesUtil.printMatrix("Given matrix is : ", matrix);

        int[][] transposedMatrix = transposeMatrix(matrix);

        MatricesUtil.printMatrix("Transposed matrix is : ", transposedMatrix);

    }

    private static int[][] transposeMatrix(int[][] matrix) {

        // have an extra space
        int[][] transposedMatrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }

}
