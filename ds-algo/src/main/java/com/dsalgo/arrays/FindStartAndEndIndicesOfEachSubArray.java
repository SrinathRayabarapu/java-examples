package com.dsalgo.arrays;

/**
 * Sliding window problem : Whenever subarray size is fixed then think about this technique
 */
public class FindStartAndEndIndicesOfEachSubArray {

    public static void main(String[] args) {
        int[] inputArray = {3, 2, -1, 4, 6, 9, 5, -4, -3, 7, 8};
        int size = 6;

        int s = 0;
        int e = size-1;

        while (e < inputArray.length){
            System.out.println("Pairs are : " + s + "," + e);
            s++;
            e++;
        }

    }

}