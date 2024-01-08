package com.dsalgo.arrays;

/**
 * given an unsorted array, find max element - in a recursive way
 *
 * #timecomplexity - O(n)
 * #spacecomplexity - O(1)
 *
 * @author Srinath.Rayabarapu
 */
public class FindMaxElementInArrayRecursiveMain {

    public static void main(String[] args) {
        int localMax = Integer.MIN_VALUE;
        int[] inputArray = {10, 22, 4, 15, 60, 6};

        int max = findMax(inputArray, localMax, 0);

        System.out.println("Max element is : " + max);
    }

    /**
     * this method recursively calls itself 'n' times
     *
     * @param inputArray
     * @param localMax
     * @param fromIndex
     * @return
     */
    private static int findMax(int[] inputArray, int localMax, int fromIndex){
        if(fromIndex == inputArray.length){ // exit condition
            return  localMax;
        } else {
            if(inputArray[fromIndex] > localMax){
                localMax = inputArray[fromIndex];
            }
            return findMax(inputArray, localMax, fromIndex+1);
        }
    }

}
