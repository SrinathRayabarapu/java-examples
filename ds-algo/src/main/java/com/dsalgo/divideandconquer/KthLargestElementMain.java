package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: Kth Largest Element in Array (QuickSelect Algorithm)
 * 
 * Interview Question: Given an integer array nums and an integer k,
 * return the kth largest element in the array.
 * 
 * Note: It is the kth largest element in sorted order, not the kth distinct element.
 * 
 * Example:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * 
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * Approach 1: QuickSelect (Divide and Conquer - similar to QuickSort)
 * - Use partition logic from QuickSort
 * - Instead of sorting both sides, only recurse into the side containing kth element
 * 
 * Approach 2: Min Heap (O(n log k))
 * Approach 3: Sorting (O(n log n))
 * 
 * Time Complexity: O(n) average, O(n^2) worst case for QuickSelect
 * Space Complexity: O(1) for iterative, O(log n) for recursive
 * 
 * @author srayabar
 */
@Slf4j
public class KthLargestElementMain {
    
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        log.info("Array: {}, k: {}", Arrays.toString(arr1), k1);
        log.info("Kth largest (QuickSelect): {}", findKthLargestQuickSelect(arr1, k1));
        log.info("Kth largest (MinHeap): {}", findKthLargestMinHeap(arr1, k1));
        
        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        log.info("Array: {}, k: {}", Arrays.toString(arr2), k2);
        log.info("Kth largest (QuickSelect): {}", findKthLargestQuickSelect(arr2, k2));
        log.info("Kth largest (MinHeap): {}", findKthLargestMinHeap(arr2, k2));
        
        int[] arr3 = {1};
        int k3 = 1;
        log.info("Array: {}, k: {}", Arrays.toString(arr3), k3);
        log.info("Kth largest (QuickSelect): {}", findKthLargestQuickSelect(arr3, k3));
    }
    
    /**
     * Find kth largest element using QuickSelect (Divide and Conquer)
     * 
     * @param nums input array
     * @param k kth largest (1-indexed)
     * @return kth largest element
     */
    public static int findKthLargestQuickSelect(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        // Convert to 0-indexed position (kth largest = (n-k)th smallest)
        int targetIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, targetIndex);
    }
    
    /**
     * QuickSelect algorithm - similar to QuickSort but only recurses into one side
     */
    private static int quickSelect(int[] nums, int left, int right, int targetIndex) {
        if (left == right) {
            return nums[left];
        }
        
        // Partition the array
        int pivotIndex = partition(nums, left, right);
        
        if (pivotIndex == targetIndex) {
            return nums[pivotIndex];
        } else if (pivotIndex < targetIndex) {
            // Target is in right partition
            return quickSelect(nums, pivotIndex + 1, right, targetIndex);
        } else {
            // Target is in left partition
            return quickSelect(nums, left, pivotIndex - 1, targetIndex);
        }
    }
    
    /**
     * Partition array around pivot (using Lomuto partition scheme)
     * Returns the final position of pivot
     */
    private static int partition(int[] nums, int left, int right) {
        // Choose rightmost element as pivot
        int pivot = nums[right];
        int i = left; // Index of smaller element
        
        for (int j = left; j < right; j++) {
            // If current element is smaller than or equal to pivot
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        
        // Place pivot in correct position
        swap(nums, i, right);
        return i;
    }
    
    /**
     * Alternative: Hoare partition scheme
     */
    private static int partitionHoare(int[] nums, int left, int right) {
        int pivot = nums[left + (right - left) / 2];
        int i = left - 1;
        int j = right + 1;
        
        while (true) {
            do {
                i++;
            } while (nums[i] < pivot);
            
            do {
                j--;
            } while (nums[j] > pivot);
            
            if (i >= j) {
                return j;
            }
            
            swap(nums, i, j);
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    /**
     * Find kth largest using Min Heap (Alternative approach)
     * Time: O(n log k), Space: O(k)
     */
    public static int findKthLargestMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest element
            }
        }
        
        return minHeap.peek();
    }
    
    /**
     * Find kth largest using sorting (Simple but less efficient)
     * Time: O(n log n), Space: O(1)
     */
    public static int findKthLargestSorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

