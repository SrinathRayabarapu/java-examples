package com.dsalgo.arrays;

/**
 * given an unsorted array, find max difference between two elements
 *
 * logic: find max and min elements in array and return difference
 *
 * Time complexity : O(n)
 *
 * @author Srinath.Rayabarapu
 */
public class MaxDifferenceInArrayMain {

    public static void main(String[] args) {
        int arr[] = {11, 40, 87, 13, 78, 5, 21};
        findMaxDifference(arr, arr.length);
    }

    private static void findMaxDifference(int[] arr, int length) {

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }

        System.out.printf("Max difference between %d, %d is : %d", max, min, (max-min));
    }

}
