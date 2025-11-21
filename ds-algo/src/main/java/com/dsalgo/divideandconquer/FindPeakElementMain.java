package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

/**
 * Problem: Find Peak Element in Array
 * 
 * Interview Question: A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array, find a peak element, and return its index.
 * 
 * Note: Array may contain multiple peaks, return any peak index.
 * For elements at boundaries, consider only one neighbor.
 * 
 * Example:
 * Input: [1, 2, 3, 1]
 * Output: 2 (index of element 3)
 * 
 * Approach:
 * - Use binary search (divide and conquer) to find peak
 * - If middle element is greater than its right neighbor, peak is in left half
 * - Otherwise, peak is in right half
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1) for iterative, O(log n) for recursive
 * 
 * @author srayabar
 */
@Slf4j
public class FindPeakElementMain {
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        log.info("Array: {}", arr1);
        log.info("Peak element index: {}", findPeakElement(arr1));
        
        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        log.info("Array: {}", arr2);
        log.info("Peak element index: {}", findPeakElement(arr2));
        
        int[] arr3 = {1, 2, 3, 4, 5};
        log.info("Array: {}", arr3);
        log.info("Peak element index: {}", findPeakElement(arr3));
        
        int[] arr4 = {5, 4, 3, 2, 1};
        log.info("Array: {}", arr4);
        log.info("Peak element index: {}", findPeakElement(arr4));
    }
    
    /**
     * Find peak element using binary search (divide and conquer)
     * 
     * @param nums array of integers
     * @return index of peak element
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare with right neighbor
            if (nums[mid] > nums[mid + 1]) {
                // Peak is in left half (including mid)
                right = mid;
            } else {
                // Peak is in right half
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    /**
     * Recursive version
     */
    public static int findPeakElementRecursive(int[] nums) {
        return findPeakHelper(nums, 0, nums.length - 1);
    }
    
    private static int findPeakHelper(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] > nums[mid + 1]) {
            return findPeakHelper(nums, left, mid);
        } else {
            return findPeakHelper(nums, mid + 1, right);
        }
    }
}

