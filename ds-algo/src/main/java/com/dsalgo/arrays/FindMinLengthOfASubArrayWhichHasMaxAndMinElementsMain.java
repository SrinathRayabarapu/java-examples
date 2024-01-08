package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * given an array {1, 2, 3, 1, 5, 6, 2, 4, 3}, find the min length sub-array such that it should have both max and min
 * elements of the array
 * <p>
 * # L1 - Medium - InterviewQuestion
 */
@Slf4j
public class FindMinLengthOfASubArrayWhichHasMaxAndMinElementsMain {

    public static void main(String[] args) {

//        int[] inputArray = {1, 2, 3, 1, 5, 6, 2, 4, 3}; // answer is 3

        int[] inputArray = {2, 2, 6, 2, 2, 2, 2, 2, 1, 4, 4, 4, 4, 6, 1}; // answer is 2

//        int[] inputArray = {8, 8, 8, 8, 8}; // answer is 1

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 1. find max and min
        for (int i : inputArray) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        log.info("Max is : {}", max);
        log.info("Min is : {}", min);

        int answer = Integer.MAX_VALUE;


        // TC: O(n^2)
        // SC: O(1)
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == min) {
                for (int j = i; j < inputArray.length; j++) {
                    if (inputArray[j] == max) {
                        answer = Math.min(answer, j - i + 1);
                    }
                }
            } else if (inputArray[i] == max) {
                for (int j = i; j < inputArray.length; j++) {
                    if (inputArray[j] == min) {
                        answer = Math.min(answer, j - i + 1);
                    }
                }
            }
        }
        log.info("Answer is : {}", answer);


        // TC: O(n)
        // SC: O(1)
        answer = Integer.MAX_VALUE;
        int lastMaxIndex = -1;
        int lastMinIndex = -1;

        if (max == min) {
            answer = 1;
        } else {
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] == min) {
                    lastMinIndex = i;
                    if (lastMaxIndex != -1) { // this is imp as we need a pair which has max and min
                        answer = Math.min(answer, i-lastMaxIndex + 1);
                    }
                } else if (inputArray[i] == max) {
                    lastMaxIndex = i;
                    if (lastMinIndex != -1) { // this is imp as we need a pair which has max and min
                        answer = Math.min(answer, i-lastMinIndex + 1);
                    }
                }
            }
        }
        log.info("Answer is : {}", answer);

    }

}
