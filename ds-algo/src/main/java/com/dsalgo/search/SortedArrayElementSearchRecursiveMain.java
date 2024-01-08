package com.dsalgo.search;

/**
 * given an sorted array, find a desired element - binary search technique
 *
 * @author Srinath.Rayabarapu
 */
public class SortedArrayElementSearchRecursiveMain {

    public static void main(String[] args) {
        int[] sortedArray = {10, 20, 30, 40, 50, 80, 90, 110};
        boolean found = findElement(sortedArray, 90, 0, sortedArray.length - 1);
        System.out.println("Is element found : " + (found ? "yes" : "no"));
    }

    /**
     * @param sortedArray
     * @param searchElement
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static boolean findElement(int[] sortedArray, int searchElement, int startIndex, int endIndex) {

        if (startIndex == endIndex && sortedArray[startIndex] == searchElement) {
            return true;
        }

        int mid = sortedArray.length / 2;

        if (sortedArray[mid] > searchElement) {
            findElement(sortedArray, searchElement, 0, mid);
        } else if (sortedArray[mid] < searchElement) {
            findElement(sortedArray, searchElement, mid, sortedArray.length - 1);
        } else if (sortedArray[mid] == searchElement) {
            return true;
        }
        return false;
    }

}