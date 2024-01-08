package com.dsalgo.arrays;

/**
 * Given an array of n non-negative integers and a non-negative target integer s,
 * find the length of smallest contiguous subarray where sum of all elements of the subarray
 * is equal to target integer 's'. If there isn't one, return -1 instead.
 *
 * Sample Input - [2,3,7,0,0,0,2,1], 10
 * Sample Output - 2
 */
public class FindMinimumSubSetSizeOfGivenSumMain {

    public static void main(String[] args) {

        int[] inputArray = {2,0,3,7,1,0,0,2,1};
        int targetSum = 10;

        int size = findMinmumSumSubSetSize(inputArray, targetSum);
        System.out.println(size);
    }
    private static int findMinmumSumSubSetSize(int[] inputArray, int targetSum) {

        int i=0;
        int j=1;

        for(int k : inputArray){
            if(k == targetSum){
                return 1;
            }
        }

        int subSetSize = Integer.MAX_VALUE;
        int tempSum = inputArray[i];

        while (i <= j && j < inputArray.length){
            if(tempSum + inputArray[j] == targetSum){
                subSetSize = Math.min(subSetSize, (j-i)+1);
                i++;
                tempSum = inputArray[i];
            } else if(tempSum + inputArray[j] < targetSum){
                tempSum += inputArray[j];
                j++;
            } else if(tempSum + inputArray[j] > targetSum){
                i++;
                j = i+1;
                tempSum = inputArray[i];
            }
        }

        return subSetSize;
    }

}