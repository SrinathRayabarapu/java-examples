package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Problem: Maximum Subarray Sum (Kadane's Algorithm + Divide and Conquer)
 * 
 * Interview Question: Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: [4, -1, 2, 1] has the largest sum = 6
 * 
 * Approach 1: Divide and Conquer
 * - Divide array into two halves
 * - Maximum subarray is either:
 *   a) In left half
 *   b) In right half
 *   c) Crossing the middle
 * 
 * Approach 2: Kadane's Algorithm (Optimal - O(n) time, O(1) space)
 * 
 * Time Complexity: O(n log n) for D&C, O(n) for Kadane's
 * Space Complexity: O(log n) for D&C, O(1) for Kadane's
 * 
 * @author srayabar
 */
@Slf4j
public class MaximumSubarraySumMain {
    
    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        log.info("Array: {}", Arrays.toString(arr1));
        log.info("Max subarray sum (D&C): {}", maxSubArrayDivideConquer(arr1));
        log.info("Max subarray sum (Kadane's): {}", maxSubArrayKadane(arr1));
        
        int[] arr2 = {1};
        log.info("Array: {}", Arrays.toString(arr2));
        log.info("Max subarray sum (D&C): {}", maxSubArrayDivideConquer(arr2));
        log.info("Max subarray sum (Kadane's): {}", maxSubArrayKadane(arr2));
        
        int[] arr3 = {5, 4, -1, 7, 8};
        log.info("Array: {}", Arrays.toString(arr3));
        log.info("Max subarray sum (D&C): {}", maxSubArrayDivideConquer(arr3));
        log.info("Max subarray sum (Kadane's): {}", maxSubArrayKadane(arr3));
        
        int[] arr4 = {-1};
        log.info("Array: {}", Arrays.toString(arr4));
        log.info("Max subarray sum (D&C): {}", maxSubArrayDivideConquer(arr4));
        log.info("Max subarray sum (Kadane's): {}", maxSubArrayKadane(arr4));
    }
    
    /**
     * Maximum subarray sum using Divide and Conquer
     * 
     * @param nums input array
     * @return maximum subarray sum
     */
    public static int maxSubArrayDivideConquer(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }
    
    /**
     * Helper method for divide and conquer
     */
    private static int maxSubArrayHelper(int[] nums, int left, int right) {
        // Base case: single element
        if (left == right) {
            return nums[left];
        }
        
        // Divide
        int mid = left + (right - left) / 2;
        
        // Conquer: find max in left and right halves
        int leftMax = maxSubArrayHelper(nums, left, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);
        
        // Combine: find max crossing the middle
        int crossMax = maxCrossingSubarray(nums, left, mid, right);
        
        // Return maximum of three
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
    
    /**
     * Find maximum subarray that crosses the middle
     */
    private static int maxCrossingSubarray(int[] nums, int left, int mid, int right) {
        // Find max sum in left half (ending at mid)
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        
        // Find max sum in right half (starting from mid+1)
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        
        return leftSum + rightSum;
    }
    
    /**
     * Kadane's Algorithm (Optimal - O(n) time, O(1) space)
     */
    public static int maxSubArrayKadane(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    /**
     * Kadane's Algorithm with indices (returns the actual subarray)
     */
    public static int[] maxSubArrayWithIndices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        
        return Arrays.copyOfRange(nums, start, end + 1);
    }
}

