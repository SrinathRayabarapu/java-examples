package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * find max product of two elements in an array
 *
 * @author Srinath
 */
@Slf4j
public class FindMaxProductInArrayMain {

    public static void main(String[] args) {
        int[] inputArray = {2, 3, 5, 1, 7, 4};
        // max product is 5 * 7 = 35
        findMaxProductInArrayOk(inputArray);
        findMaxProductInArrayGood(inputArray);

        int[] inputArray1 = {-1, 3, -9, -9, 6};
        // max product is -9 * -9 = 81
        findMaxProductInArrayOk(inputArray1);
        findMaxProductInArrayGood(inputArray);
    }

    /**
     * TC: O(n^2)
     * @param inputArray
     */
    private static void findMaxProductInArrayOk(int[] inputArray) {

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < inputArray.length; i++) {
            for(int j = i+1; j < inputArray.length; j++){
                int temp = inputArray[i] * inputArray[j];
                max = Math.max(max, temp);
            }
        }

        log.info("Max is : {}", max);
    }

    /**
     * TC: O(n)
     * @param inputArray
     */
    // find two max +ve and -ve numbers and compare their product
    private static void findMaxProductInArrayGood(int[] inputArray) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int j : inputArray) {
            if (max1 < j) {
                max2 = max1;
                max1 = j;
            } else if (max2 < j) {
                max2 = j;
            } else if (j < min1) {
                min2 = min1;
                min1 = j;
            } else if (j < min2) {
                min2 = j;
            }
        }

        log.info("Max1 : {} and Max2 : {}", max1, max2);
        log.info("Min1 : {} and Min2 : {}", min1, min2);

        int product1 = max1 * max2;
        int product2 = min1 * min2;

        log.info("Max product is : {}", Math.max(product1, product2));
    }

}
