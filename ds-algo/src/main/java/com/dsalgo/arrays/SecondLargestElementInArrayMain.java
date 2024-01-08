package com.dsalgo.arrays;

import java.util.Arrays;

/**
 * given an array of numbers, find second-largest element
 *
 * @author Srinath Rayabarapu
 */
public class SecondLargestElementInArrayMain {

    public static void main(String[] args) {

        int[] intArray = {-1, -3, -4, -5, 0, -2};
        // initializing to Integer.MIN_VALUE is important as it will consider -ve values also
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < intArray.length; i++) {
            if(largest < intArray[i]){
                secondLargest = largest;
                largest = intArray[i];
            }
        }

        System.out.println("Array: " + Arrays.toString(intArray));
        System.out.println("Large value: " + largest +", " + "Second value: " + secondLargest);
    }

}