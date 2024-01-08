package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * given an array {1, 2, 3, 1, 5, 6, 2, 4, 3}, find the max length sub-array such that it should have both max and min
 * elements of the array
 *
 *  # L1 - Medium - InterviewQuestion
 */
@Slf4j
public class FindMaxLengthOfASubArrayWhichHasMaxAndMinElementsMain {

    public static void main(String[] args) {

//        int[] inputArray = {1, 2, 3, 1, 5, 6, 2, 4, 3}; // answer is 6

//        int[] inputArray = {2, 2, 6, 2, 2, 2, 2, 2, 1, 4, 4, 4, 4, 6, 1}; // answer is 13

        int[] inputArray = {8, 8, 8, 8, 8}; // answer is 5

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 1. find max and min
        for (int i : inputArray) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        log.info("Max is : {}", max);
        log.info("Min is : {}", min);

        // TC: O(n)
        // SC: O(1)
        int answer = Integer.MIN_VALUE;
        int firstMaxIndex = Integer.MAX_VALUE;
        int firstMinIndex = Integer.MAX_VALUE;

        if (max == min) {
            answer = inputArray.length;
        } else {
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] == min) {
                    firstMinIndex = Math.min(firstMinIndex, i);
                    if (firstMaxIndex != Integer.MAX_VALUE) { // this is imp as we need a pair which has max and min
                        answer = Math.max(answer, i - firstMaxIndex + 1);
                    }
                } else if (inputArray[i] == max) {
                    firstMaxIndex = Math.min(firstMaxIndex, i);
                    if (firstMinIndex != Integer.MAX_VALUE) { // this is imp as we need a pair which has max and min
                        answer = Math.max(answer, i - firstMinIndex + 1);
                    }
                }
            }
        }
        log.info("Answer is : {}", answer);

    }

}