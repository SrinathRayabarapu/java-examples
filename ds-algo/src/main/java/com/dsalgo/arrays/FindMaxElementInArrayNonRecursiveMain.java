package com.dsalgo.arrays;

/**
 * given an unsorted array, find max element - in non-recursive way
 *
 * #timecomplexity - O(n)
 * #spacecomplexity - O(1)
 *
 * @author Srinath.Rayabarapu
 */
public class FindMaxElementInArrayNonRecursiveMain {

    public static void main(String[] args) {
        int[] inputArray = {10, 22, 4, 15, 60, 6};

        int max = Integer.MIN_VALUE;

        for (int element: inputArray) { // looping an array of length n
            if(max < element){
                max = element;
            }
        }

        System.out.println("Max element is : " + max);

    }
}
