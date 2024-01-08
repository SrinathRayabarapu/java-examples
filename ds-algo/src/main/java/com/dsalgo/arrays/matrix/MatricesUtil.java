package com.dsalgo.arrays.matrix;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MatricesUtil {

    public static void printMatrix(String message, int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++){
                stringBuilder.append(matrix[i][j] + " ");
            }
            stringBuilder.append("\n");
        }
        log.info("{} {}",message, stringBuilder);
    }

}
