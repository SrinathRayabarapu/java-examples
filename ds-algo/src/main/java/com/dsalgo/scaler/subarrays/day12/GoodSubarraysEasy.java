package com.dsalgo.scaler.subarrays.day12;

/**
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one
 * of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 */
public class GoodSubarraysEasy {

    public static void main(String[] args) {
        int[] intArray = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int maxSum = 65;

        int count = countGoodArrays(intArray, maxSum);
        System.out.println("count = " + count);
    }

    private static int countGoodArrays(int[] intArray, int maxSum) {

        int counter = 0;

        for (int i = 0; i < intArray.length; i++) {
            int sum = 0;
            for (int j = i; j < intArray.length; j++) {
                // carry forward and check all conditions
                sum += intArray[j];

                if (sum < maxSum && ((j-i)+1)%2 == 0) {
                    counter++;
                    continue;
                }
                if(maxSum < sum && ((j-i)+1)%2 == 1) {
                    counter++;
                }
            }
        }

        return counter;
    }

}