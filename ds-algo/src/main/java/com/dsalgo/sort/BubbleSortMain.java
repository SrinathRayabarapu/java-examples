package com.dsalgo.sort;

import java.util.Arrays;

/**
 * Bubble sort is a simple sorting algorithm that works by repeatedly stepping through the list to be sorted,
 * comparing each pair of adjacent items and swapping them if they are in the wrong order. The pass through the
 * list is repeated until no swaps are needed, which indicates that the list is sorted.
 * <p>
 * Family: Exchanging. Space: In-place. Stable: True
 * Time complexity:
 * Average case = O(n^2)
 * Worst case = O(n^2)
 * Best case = O(n)
 * <p>
 * below program shows two approaches but both are same!
 * <p>
 * logic:
 * 1. iterate from array end to start
 * 2. iterate from array start with first loop i value - j
 * 3. compare  j and j+1 and swap
 * <p>
 *
 * @author Srinath.Rayabarapu
 */
public class BubbleSortMain {

    public static void main(String[] args) {
        Integer[] inputArray = {2, 8, 45, 0, 5, 77, 75, 1};
        System.out.println("Before Sort : " + Arrays.toString(inputArray));
        doBubbleSort1(inputArray);
        System.out.println("After Sort : " + Arrays.toString(inputArray));
    }

    /**
     * with both loop1 and loop2 starting from start.
     *
     * @param inputArray
     */
    private static void doBubbleSort(Integer[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 1; j < inputArray.length; j++) {
                if (inputArray[j - 1] > inputArray[j]) {
                    int temp = inputArray[j - 1]; //swap the values
                    inputArray[j - 1] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }
    }

    /**
     * with loop1 starting from end and loop2 starting from start.
     *
     * @param inputArray
     */
    private static void doBubbleSort1(Integer[] inputArray) {
        for (int i = inputArray.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    int temp = inputArray[j + 1]; //swap the values
                    inputArray[j + 1] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }
    }

}