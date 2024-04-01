package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SumOfAllSubArraysSumsMain {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        int sum = findSumWorst(arr);
        log.info("Sum : {}", sum);

        long sum2 = findSumGood(arr);
        log.info("Sum : {}", sum2);
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static long findSumGood(int[] arr) {
        long totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i] * (long)(i + 1) * (arr.length - i);
            // element * it's left positions * it's right positions
            // (i+1) is the number of times i position can start
            //(n-i) is the number of times i position can end
        }
        return totalSum;
    }

    /**
     * TC : O(n^2)
     * SC: O(1)
     */
    private static int findSumWorst(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            for (int j = i; j < arr.length; j++) {
//                log.info("" + arr[j]);
                tempSum += arr[j];
                maxSum += tempSum;
            }
        }
        return maxSum;
    }

}
