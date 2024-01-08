package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SumOfAllSubArraysSumsMain {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        int sum = findSumWorst(arr);
        log.info("Sum : {}", sum);

        int sum2 = findSumGood(arr);
        log.info("Sum : {}", sum);
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int findSumGood(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum = (i + 1) * (arr.length - i) * arr[i];
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
