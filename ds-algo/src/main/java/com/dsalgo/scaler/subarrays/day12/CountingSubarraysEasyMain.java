package com.dsalgo.scaler.subarrays.day12;

/**
 * Given an array A of N non-negative numbers and a non-negative number B,
 * you need to find the number of subarrays in A with a sum less than B.
 * We may assume that there is no overflow.
 */
public class CountingSubarraysEasyMain {

    public static void main(String[] args) {

        int[] intArray = {1, 11, 2, 3, 15};
        int maxSum = 10;

        int count = countSubArray(intArray, maxSum);
        System.out.println("count = " + count);

    }

    private static int countSubArray(int[] intArray, int maxSum) {

        int counter = 0;

        for (int i = 0; i < intArray.length; i++) {
            int sum = 0;
            for (int j = i; j < intArray.length; j++) {
                // carry forward until condition matches
                sum += intArray[j];

                if(sum < maxSum){
                    counter++;
                } else {
                    break;
                }
            }
        }

        return counter;
    }

}