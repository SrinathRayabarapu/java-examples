package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * given an array [1, 0, 0, 1, 1, 0, 1, 1], sort the array such that all 0's should come forward followed by 1's
 *
 */
@Slf4j
public class SortOsAnd1sMain {

    public static void main(String[] args) {

        int[] input = new int[]{1, 0, 0, 1, 1, 0, 1, 1};

        log.info("Given array : {}", Arrays.toString(input));

        easyApproach(input);

        input = new int[]{1, 0, 0, 1, 1, 0, 1, 1};

        betterApproach(input);

    }

    /**
     * TC: O(n) but only 1 pass of the array
     * @param input
     */
    private static void betterApproach(int[] input) {
        int left =0;
        int right = input.length-1;

        while (left < right){
            if (input[left] == 1){
                // swap
                input[right] = input[right] + input[left];
                input[left] = input[right] - input[left];
                input[right] = input[right] - input[left];

                right--;
            } else {
                left++;
            }
        }

        log.info("Sorted array : {}", Arrays.toString(input));
    }

    /**
     * TC: O(n) but two passes of the array
     * @param input
     */
    private static void easyApproach(int[] input) {
        // find all the 0's count first
        int zerosCount = 0;
        for (int i : input){
            if(i == 0){
                zerosCount++;
            }
        }

        // set first zerosCount to 0 and remaining to 1
        for (int i = 0; i < input.length; i++) {
            if(i < zerosCount){
                input[i] = 0;
            } else {
                input[i] = 1;
            }
        }

        log.info("Sorted array : {}", Arrays.toString(input));
    }

}
