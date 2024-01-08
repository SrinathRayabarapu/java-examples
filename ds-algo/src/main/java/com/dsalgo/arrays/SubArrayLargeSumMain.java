package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * Find the sub-array within an array A of length N, with the largest sum
 * <p>
 * # L1 - Medium - InterviewQuestion
 */
@Slf4j
public class SubArrayLargeSumMain {

    public static void main(String[] args) {
        int[] inputArray = {-1, 2, 3, 4, -10};

        int largeSum = findLargestSubArray(inputArray);

        log.info("Large sum is : {}", largeSum);
    }

    /**
     * this technique is called - "carry forward"
     *
     * @param inputArray
     * @return
     */
    private static int findLargestSubArray(int[] inputArray) {
        int maxSum = inputArray[0];
        int currentSum = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (currentSum < 0) {
                currentSum = 0; // not to carry the backlog of any -ve numbers
            }
            currentSum = currentSum + inputArray[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}
