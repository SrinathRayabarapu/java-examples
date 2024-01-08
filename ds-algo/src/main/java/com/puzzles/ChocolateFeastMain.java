package com.puzzles;

/**
 * TODO: understand and update description
 *
 * https://www.hackerrank.com/challenges/chocolate-feast/problem
 *
 * @author Srinath.Rayabarapu
 */
public class ChocolateFeastMain {

    /*
     * Sample input
     * 3
     * 10 2 5
     * 12 4 4
     * 6 2 2
     *
     * Sample Output 6 3 5
     */
    public static void main(String[] args) {

        int[][] inputData = {{10, 2, 5}, {12, 4, 4}, {6, 2, 2}};

        for (int i = 0; i < inputData.length; i++) {
            int chocolates = calculateChociis(inputData[i][0], inputData[i][1], inputData[i][2]);
            System.out.println(chocolates);
        }
    }

    private static int calculateChociis(int bill, int chociiPrice, int wrappers) {
        int chociis = 0;
        if (chociiPrice == 0 && wrappers == 0) {
            chociis = bill;
        } else if (chociiPrice != 0 && wrappers == 0) {
            chociis = bill / chociiPrice;
        } else if (chociiPrice == 0 && wrappers != 0) {
            chociis = bill + (bill / wrappers);
        } else if (chociiPrice != 0 && wrappers != 0 && chociis <= wrappers) {
            chociis = bill / chociiPrice;
            chociis = chociis + calculateChociis(bill, chociiPrice, chociis / wrappers);
        }
        return chociis;
    }
}