package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Problem: Find First and Last Position of Element in Sorted Array
 * 
 * Interview Question: Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * 
 * Example:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Approach:
 * - Use binary search (divide and conquer) to find first occurrence
 * - Use binary search to find last occurrence
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * @author srayabar
 */
@Slf4j
public class FindFirstLastPositionMain {
    
    public static void main(String[] args) {
        int[] arr1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        log.info("Array: {}, Target: {}", Arrays.toString(arr1), target1);
        int[] result1 = searchRange(arr1, target1);
        log.info("First and Last Position: {}", Arrays.toString(result1));
        
        int[] arr2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        log.info("Array: {}, Target: {}", Arrays.toString(arr2), target2);
        int[] result2 = searchRange(arr2, target2);
        log.info("First and Last Position: {}", Arrays.toString(result2));
        
        int[] arr3 = {1};
        int target3 = 1;
        log.info("Array: {}, Target: {}", Arrays.toString(arr3), target3);
        int[] result3 = searchRange(arr3, target3);
        log.info("First and Last Position: {}", Arrays.toString(result3));
        
        int[] arr4 = {2, 2};
        int target4 = 2;
        log.info("Array: {}, Target: {}", Arrays.toString(arr4), target4);
        int[] result4 = searchRange(arr4, target4);
        log.info("First and Last Position: {}", Arrays.toString(result4));
    }
    
    /**
     * Find first and last position of target in sorted array
     * 
     * @param nums sorted array
     * @param target value to search
     * @return array with [firstIndex, lastIndex] or [-1, -1] if not found
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // Find first occurrence
        result[0] = findFirst(nums, target);
        
        // If target not found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }
        
        // Find last occurrence
        result[1] = findLast(nums, target);
        
        return result;
    }
    
    /**
     * Find first occurrence of target using binary search
     */
    private static int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstIndex = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                firstIndex = mid;
                // Continue searching in left half
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return firstIndex;
    }
    
    /**
     * Find last occurrence of target using binary search
     */
    private static int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastIndex = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                lastIndex = mid;
                // Continue searching in right half
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return lastIndex;
    }
    
    /**
     * Alternative: Single pass approach
     */
    public static int[] searchRangeSinglePass(int[] nums, int target) {
        int[] result = {-1, -1};
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        // Find left boundary
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] != target) {
            return result;
        }
        
        result[0] = left;
        
        // Find right boundary
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1; // Bias to right
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        
        result[1] = right;
        
        return result;
    }
}

