package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class MaxElementInArrayUpToAnIndexMain {

    public static void main(String[] args) {

        int[] input = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};
        int i = 5;

        int max = findMaxTillIndex(input, i);

        log.info("Max element so far is : {}", max);
    }

    /**
     * TC : O(n)
     * SC : O(n)
     *
     * @param inputArray
     * @param index
     * @return
     */
    private static int findMaxTillIndex(int[] inputArray, int index) {

        int[] leftMaxArray = new int[inputArray.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            if(max < inputArray[i]){
                max = inputArray[i];
            }
            leftMaxArray[i] = max;
        }

        return leftMaxArray[index];
    }

}