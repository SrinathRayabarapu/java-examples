package com.dsalgo.scaler.sorting.day20;

import java.util.Arrays;

/**
 * Given an integer array A of size N. You can remove any element from the array in one operation.
 * The cost of this operation is the sum of all elements in the array present before this operation.
 *
 * Find the minimum cost to remove all elements from the array.
 */
public class ElementsRemoval {

    public static void main(String[] args) {

        int[] intArray = {5};

        int totalCost = calculateTotalCost(intArray);
        System.out.println(totalCost);
    }

    private static int calculateTotalCost(int[] intArray) {
        Arrays.sort(intArray);

        int[] preFixArray = new int[intArray.length];
        preFixArray[0] = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            preFixArray[i] += preFixArray[i-1] + intArray[i];
        }

        int totalCost = 0;
        for (int i = 0; i < intArray.length; i++) {
            totalCost += preFixArray[i];
        }

        return totalCost;
    }

}
