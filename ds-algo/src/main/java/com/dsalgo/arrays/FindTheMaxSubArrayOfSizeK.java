package com.dsalgo.arrays;

/**
 * this is a sliding window problem
 *
 * Pro Tip: Whenever you see fixed subarray then consider thinking in sliding window technique
 *
 * TC: O(n)
 * SC: O(1)
 */
public class FindTheMaxSubArrayOfSizeK {

    public static void main(String[] args) {

        int[] inputArray = {-3, 4, -2, 5, 3, -2, 8, 2, -1, 4};
        int size = 5;

        // 1. find the sum of first k sub array
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            sum += inputArray[i];
        }

        ans = Math.max(ans, sum);

        // 2. go to next window and add next value and remove trailing value and continue..
        int s = 1;
        int e = size;
        while (e < inputArray.length) {
            sum = sum + inputArray[e] - inputArray[s - 1];
            ans = Math.max(ans, sum);
            s++;
            e++;
        }

        System.out.println("Max subarray sum is : " + ans);
    }

}