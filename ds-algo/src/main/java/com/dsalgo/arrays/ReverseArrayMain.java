package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * given an array, reverse it in-place.
 * <p>
 * logic: iterate till array median, where swap arr[i] element to arr[arr.length - (i+1)]
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class ReverseArrayMain {

    public static void main(String[] args) {

        int[] array = {9, 8, 7, 6, 14};

        log.info("Original array : {}", Arrays.toString(array));

//		reverseArray(array);
        reverseArrayTwoPointer(array);

        log.info("Reversed array : {}", Arrays.toString(array));

    }

    private static void reverseArrayTwoPointer(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
			i++;
			j--;
        }
    }

    private static void reverseArray(int[] a) {
        //reversing array - swapping first and last elements
        for (int i = 0; i < a.length / 2; i++) {
            int j = a[i];
            int k = a[a.length - (i + 1)];
            a[a.length - (i + 1)] = j;
            a[i] = k;
        }
    }

}