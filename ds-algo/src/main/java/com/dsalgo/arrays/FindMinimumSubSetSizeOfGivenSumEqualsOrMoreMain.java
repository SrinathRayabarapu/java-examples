package com.dsalgo.arrays;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class FindMinimumSubSetSizeOfGivenSumEqualsOrMoreMain {

    public static void main(String[] args) {

        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        int i = minSubArrayLen(target, nums);

        System.out.println("Min subset size : " + i);
    }

    /**
     * TC : O(n)
     * SC: O(1)
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int left = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
