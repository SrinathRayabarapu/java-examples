package com.dsalgo.arrays;

import java.util.Arrays;

/**
 * given an arrays of jumbled 0s and 1s, rearrange it in such a way 0's to left and 1's to right
 *
 * @author Srinath.Rayabarapu
 */
public class JumbledZerosNOnesMain {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 1, 0, 1, 1, 0};
        move(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * start from end, check if 0 then start from beginning check if 1 then swap
     * @param arr
     */
    private static void move(int[] arr) {
        int end = arr.length-1;
        int start = 0;
        while ( start < end){
            if(arr[end] == 0){
                if(arr[start] == 1){
                    swap(arr, start, end);
                } else {
                    start++;
                }
            } else {
                end--;
            }
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
