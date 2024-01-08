package com.dsalgo.arrays.matrix;

/**
 * Util class for all matrices exercises.
 *
 * @author srinath.rayabarapu
 */
public class MatrixPracticeMain {

    /**
     * prints given matrix to standard output.
     *
     * @param sourceArray
     */
    public static void printArray(int[][] sourceArray) {

        String printMe = "";
        for (int i = 0; i < sourceArray.length; i++) {
            printMe = "";
            for (int j = 0; j < sourceArray[i].length; j++) {
                printMe = printMe + sourceArray[i][j] + " ";
            }
            System.out.println(printMe.trim());
        }

        int a[][] = new int[2][2]; // 2 rows and 2 columns
        a[0][0] = 10;
        a[0][1] = 20;
        a[1][0] = 30;
        a[1][1] = 40;

        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[row].length; column++) {
                System.out.print(a[row][column] + " ");
            }
            System.out.println("");
        }

        // TODO
        // reverse the matrix up-down and right-left

        // many other appraoches are here - do check and practice
        // https://levelup.gitconnected.com/make-way-for-the-matrix-a-complete-guide-to-solving-2d-array-coding-problems-725096d122d9
        // https://www.youtube.com/watch?v=HMqUv7zmxmo&ab_channel=ProgrammingTutorials

    }
}
