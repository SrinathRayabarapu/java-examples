package com.dsalgo.arrays;

/**
 * given a sorted array, find Maximum difference between two elements such that the
 * larger element appears after the smaller number.
 * <p>
 * Note: it only finds difference where smaller element is first and larger is after that in sequence
 *
 * @author Srinath.Rayabarapu
 */
public class MaxDifferenceInArrayForwardElementsMain {

    public static void main(String[] args) {
        int arr[] = {2, 10, 90, 111, 10, 2000, 1};

        maxDiff(arr, arr.length);

        maxDiffEfficient(arr, arr.length);
    }

    /**
     * logic: iterate array in two loops and find difference between i and j
     * <p>
     * Time complexity : O(n^2)
     *
     * @param arr
     * @param size
     */
    private static void maxDiff(int[] arr, int size) {

        int max = arr[1] - arr[0];
        int lower = arr[0], greater = arr[1];

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (max < (arr[j] - arr[i])) {
                    max = arr[j] - arr[i];
                    lower = arr[i];
                    greater = arr[j];
                }
            }
        }

        // $s is for string and %d is for integer
        System.out.printf("Max %d found between %d and %d%n", max, lower, greater);
    }

    /**
     * keep track of max element and find the max difference with every element
     *
     * Time complexity: O(n)
     *
     * @param arr
     * @param size
     */
    private static void maxDiffEfficient(int[] arr, int size) {

        int maxDiff = -1;
        int maxRight = arr[size-1];

        int start = 0, end = 0;

        for (int i = size-2; i >= 0; i--) {
            if(arr[i] > maxRight){
                maxRight = arr[i];
                end = maxRight;
            } else {
                int diff = maxRight - arr[i];
                if(diff > maxDiff){
                    maxDiff = diff;
                    start = arr[i];
                }
            }
        }

        System.out.printf("Max %d found between %d and %d%n", maxDiff, start, end);
    }

}