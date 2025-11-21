package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Problem: Count Inversions in Array
 * 
 * Interview Question: Given an array, count the number of inversions.
 * An inversion is a pair (i, j) such that i < j and arr[i] > arr[j]
 * 
 * Example:
 * Input: [2, 4, 1, 3, 5]
 * Inversions: (2,1), (4,1), (4,3) -> Output: 3
 * 
 * Approach:
 * - Use modified merge sort (divide and conquer)
 * - While merging, count inversions when element from right subarray is smaller
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * 
 * @author srayabar
 */
@Slf4j
public class CountInversionsMain {
    
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 3, 5};
        log.info("Array: {}", Arrays.toString(arr1));
        log.info("Number of inversions: {}", countInversions(arr1));
        
        int[] arr2 = {5, 4, 3, 2, 1};
        log.info("Array: {}", Arrays.toString(arr2));
        log.info("Number of inversions: {}", countInversions(arr2));
        
        int[] arr3 = {1, 2, 3, 4, 5};
        log.info("Array: {}", Arrays.toString(arr3));
        log.info("Number of inversions: {}", countInversions(arr3));
        
        int[] arr4 = {8, 4, 2, 1};
        log.info("Array: {}", Arrays.toString(arr4));
        log.info("Number of inversions: {}", countInversions(arr4));
    }
    
    /**
     * Count inversions using modified merge sort
     * 
     * @param arr input array
     * @return number of inversions
     */
    public static long countInversions(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        
        int[] temp = new int[arr.length];
        return countInversionsHelper(arr, temp, 0, arr.length - 1);
    }
    
    /**
     * Helper method that divides and counts inversions
     */
    private static long countInversionsHelper(int[] arr, int[] temp, int left, int right) {
        long inversionCount = 0;
        
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Count inversions in left subarray
            inversionCount += countInversionsHelper(arr, temp, left, mid);
            
            // Count inversions in right subarray
            inversionCount += countInversionsHelper(arr, temp, mid + 1, right);
            
            // Count inversions while merging
            inversionCount += mergeAndCount(arr, temp, left, mid, right);
        }
        
        return inversionCount;
    }
    
    /**
     * Merge two sorted subarrays and count inversions
     */
    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy elements to temporary array
        System.arraycopy(arr, left, temp, left, right - left + 1);
        
        int i = left;      // Index for left subarray
        int j = mid + 1;   // Index for right subarray
        int k = left;      // Index for merged array
        long inversionCount = 0;
        
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                // Inversion found: all elements from i to mid are greater than temp[j]
                arr[k++] = temp[j++];
                inversionCount += (mid - i + 1);
            }
        }
        
        // Copy remaining elements
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        while (j <= right) {
            arr[k++] = temp[j++];
        }
        
        return inversionCount;
    }
}

