package com.dsalgo.arrays;

public class MaximumSubarrayEasyMain {

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 4, 5};
        int maxSum = maxSubarray(5, 12, array);
        System.out.println("maxSum = " + maxSum);
    }

    public static int maxSubarray(int arraySize, int maxSum, int[] array) {

        int targetSum = 0;

        for (int i = 0; i < arraySize; i++) {
            int sum=0;
            for (int j = i; j < arraySize; j++) {
                sum += array[j];
                if(sum <= maxSum){
                    targetSum = Math.max(sum, targetSum);
                } else {
                    break;
                }
            }
        }
        return targetSum;
    }

}