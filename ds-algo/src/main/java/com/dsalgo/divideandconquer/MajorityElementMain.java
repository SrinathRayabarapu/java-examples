package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Find Majority Element
 * 
 * Interview Question: Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊n/2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * Example:
 * Input: [3, 2, 3]
 * Output: 3
 * 
 * Input: [2, 2, 1, 1, 1, 2, 2]
 * Output: 2
 * 
 * Approach 1: Divide and Conquer
 * - Divide array into two halves
 * - Find majority in each half
 * - If both halves have same majority, return it
 * - Otherwise, count which one appears more
 * 
 * Approach 2: Boyer-Moore Voting Algorithm (more efficient)
 * 
 * Time Complexity: O(n log n) for D&C, O(n) for Boyer-Moore
 * Space Complexity: O(log n) for D&C, O(1) for Boyer-Moore
 * 
 * @author srayabar
 */
@Slf4j
public class MajorityElementMain {
    
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 3};
        log.info("Array: {}", Arrays.toString(arr1));
        log.info("Majority element (D&C): {}", majorityElementDivideConquer(arr1));
        log.info("Majority element (Boyer-Moore): {}", majorityElementBoyerMoore(arr1));
        
        int[] arr2 = {2, 2, 1, 1, 1, 2, 2};
        log.info("Array: {}", Arrays.toString(arr2));
        log.info("Majority element (D&C): {}", majorityElementDivideConquer(arr2));
        log.info("Majority element (Boyer-Moore): {}", majorityElementBoyerMoore(arr2));
        
        int[] arr3 = {1, 1, 1, 2, 2};
        log.info("Array: {}", Arrays.toString(arr3));
        log.info("Majority element (D&C): {}", majorityElementDivideConquer(arr3));
        log.info("Majority element (Boyer-Moore): {}", majorityElementBoyerMoore(arr3));
    }
    
    /**
     * Find majority element using Divide and Conquer
     * 
     * @param nums input array
     * @return majority element
     */
    public static int majorityElementDivideConquer(int[] nums) {
        return majorityElementHelper(nums, 0, nums.length - 1);
    }
    
    /**
     * Helper method for divide and conquer
     */
    private static int majorityElementHelper(int[] nums, int left, int right) {
        // Base case: single element
        if (left == right) {
            return nums[left];
        }
        
        // Divide
        int mid = left + (right - left) / 2;
        int leftMajority = majorityElementHelper(nums, left, mid);
        int rightMajority = majorityElementHelper(nums, mid + 1, right);
        
        // If both halves agree on majority
        if (leftMajority == rightMajority) {
            return leftMajority;
        }
        
        // Otherwise, count occurrences of each candidate
        int leftCount = countInRange(nums, leftMajority, left, right);
        int rightCount = countInRange(nums, rightMajority, left, right);
        
        return leftCount > rightCount ? leftMajority : rightMajority;
    }
    
    /**
     * Count occurrences of a number in a range
     */
    private static int countInRange(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Boyer-Moore Voting Algorithm (Optimal - O(n) time, O(1) space)
     */
    public static int majorityElementBoyerMoore(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        // Phase 1: Find candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        // Phase 2: Verify candidate (if we can't assume majority exists)
        // For this problem, we assume majority exists, so we skip verification
        
        return candidate;
    }
    
    /**
     * Alternative: Using HashMap (O(n) time and space)
     */
    public static int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majorityCount = nums.length / 2;
        
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > majorityCount) {
                return num;
            }
        }
        
        return -1; // Should not reach here if majority exists
    }
}

