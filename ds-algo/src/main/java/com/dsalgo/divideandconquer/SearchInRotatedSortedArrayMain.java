package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Problem: Search in Rotated Sorted Array
 * 
 * Interview Question: There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k.
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * 
 * Example:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 * Approach:
 * - Use binary search (divide and conquer)
 * - Determine which half is sorted
 * - Check if target lies in sorted half, otherwise search in other half
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * @author srayabar
 */
@Slf4j
public class SearchInRotatedSortedArrayMain {
    
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        log.info("Array: {}, Target: {}", Arrays.toString(arr1), target1);
        log.info("Index: {}", search(arr1, target1));
        
        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        log.info("Array: {}, Target: {}", Arrays.toString(arr2), target2);
        log.info("Index: {}", search(arr2, target2));
        
        int[] arr3 = {1};
        int target3 = 0;
        log.info("Array: {}, Target: {}", Arrays.toString(arr3), target3);
        log.info("Index: {}", search(arr3, target3));
        
        int[] arr4 = {5, 1, 3};
        int target4 = 3;
        log.info("Array: {}, Target: {}", Arrays.toString(arr4), target4);
        log.info("Index: {}", search(arr4, target4));
    }
    
    /**
     * Search target in rotated sorted array using binary search
     * 
     * @param nums rotated sorted array
     * @param target value to search
     * @return index of target, or -1 if not found
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is in left sorted half
                    right = mid - 1;
                } else {
                    // Target is in right half
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target is in right sorted half
                    left = mid + 1;
                } else {
                    // Target is in left half
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Recursive version
     */
    public static int searchRecursive(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }
    
    private static int searchHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid;
        }
        
        // Left half is sorted
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                return searchHelper(nums, target, left, mid - 1);
            } else {
                return searchHelper(nums, target, mid + 1, right);
            }
        } else {
            // Right half is sorted
            if (target > nums[mid] && target <= nums[right]) {
                return searchHelper(nums, target, mid + 1, right);
            } else {
                return searchHelper(nums, target, left, mid - 1);
            }
        }
    }
}

