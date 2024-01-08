package com.dsalgo.arrays;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * given an array, check whether it is sorted using recursion
 *
 * Time Complexity: O(n)
 *
 * @author Srinath.Rayabarapu
 */
public class CheckArraySortedWithRecursionMain {

    private static final Logger LOG = LoggerFactory.getLogger(CheckArraySortedWithRecursionMain.class);

    public static void main(String[] args) {

        int[] inputArray1 = {1, 5, 2, 99, 4, 55, 12, 1001, 43, 3};
        boolean isSorted = checkArraySortedRecursivelyBookish(inputArray1, 0);
        LOG.info("Sorted : " + isSorted);

        int[] inputArray2 = {1, 5, 12, 23, 56, 78, 101, 197, 228};
        isSorted = checkArraySortedRecursivelyBookish(inputArray2, 0);
        LOG.info("Sorted : " + isSorted);

    }

    /**
     * check whether current index element is less its next element or not.
     *
     * @param inputArray
     * @param startIndex
     * @return
     */
    private static boolean checkArraySortedRecursively(int[] inputArray, int startIndex) {
        if (startIndex + 1 != inputArray.length) {
            if (inputArray[startIndex] < inputArray[startIndex + 1]) {
                return checkArraySortedRecursively(inputArray, startIndex + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * copied from book - simple and elegant approach
     *
     * @param inputArray
     * @param startIndex
     * @return
     */
    private static boolean checkArraySortedRecursivelyBookish(int[] inputArray, int startIndex) {
        if (startIndex + 1 != inputArray.length) {
            return (inputArray[startIndex] < inputArray[startIndex + 1]
                    && checkArraySortedRecursivelyBookish(inputArray, startIndex + 1));
        }
        return true;
    }

}
