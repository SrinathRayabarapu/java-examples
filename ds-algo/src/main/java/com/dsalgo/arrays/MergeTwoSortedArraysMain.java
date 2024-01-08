package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * given two sorted arrays, merge them.
 *
 * TODO - need to implement few methods
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class MergeTwoSortedArraysMain {

    private static int INVALID_NUM = 0;

    public static void main(String[] args) {

        // 1. usecase where you can create an extra array as target
        int[] intArray1 = {1, 2, 3, 5, 6, 7, 11};
        int[] intArray2 = {2, 4, 6, 8, 16};
        mergeTwoSortedArraysWithExtraSpace(intArray1, intArray2);

        // 2. usecase where one of the given arrays will be having extra space
        int[] a = {1, 3, 8, 9};
        int[] b = {2, 4, 5, 6, 7, 0, 0, 0, 0}; // last four as place holders for the merge
        mergeTwoSortedArraysWithOutExtraSpace(a, b);

    }

    // TODO
    private static void mergeTwoSortedArraysWithOutExtraSpace(int[] a, int[] b) {

    }

    /**
     * Time complexity : O(n + m) where n and m are lengths of two input arrays
     * Space/Auxiliary complexity : O(n + m)
     *
     * @param intArray1
     * @param intArray2
     */
    private static void mergeTwoSortedArraysWithExtraSpace(int[] intArray1, int[] intArray2) {

        int[] targetArray = new int[intArray1.length + intArray2.length];

        int i=0, j=0, k=0 ;

        while(i < intArray1.length && j < intArray2.length){
            // compare against each array element and copy it to target array
            if(intArray1[i] < intArray2[j]){
                targetArray[k++] = intArray1[i++];
            } else {
                targetArray[k++] = intArray2[j++];
            }
        }

        // copy remaining first array elements to target array
        while(i < intArray1.length){
            targetArray[k++] = intArray1[i++];
        }

        // copy remaining second array elements to target array
        while(j < intArray2.length){
            targetArray[k++] = intArray2[j++];
        }

        log.info(Arrays.toString(targetArray));
    }

}
