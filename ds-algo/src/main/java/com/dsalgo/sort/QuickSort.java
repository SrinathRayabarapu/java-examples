package com.dsalgo.sort;

import java.util.Random;

/**
 * QuickSort - An efficient, in-place, divide-and-conquer sorting algorithm.
 * 
 * <p>QuickSort is one of the most widely used sorting algorithms. It works by selecting
 * a 'pivot' element and partitioning the array around it, placing smaller elements
 * to the left and larger elements to the right.</p>
 * 
 * <h3>Algorithm Steps:</h3>
 * <ol>
 *   <li><b>Pick a pivot</b>: Select an element as the pivot (first, middle, or random)</li>
 *   <li><b>Partition</b>: Rearrange array so elements less than pivot come before,
 *       elements greater come after</li>
 *   <li><b>Recurse</b>: Recursively apply to sub-arrays</li>
 * </ol>
 * 
 * <h3>Complexity Analysis:</h3>
 * <table border="1">
 *   <tr><th>Case</th><th>Time</th><th>When</th></tr>
 *   <tr><td>Best</td><td>O(n log n)</td><td>Balanced partitions</td></tr>
 *   <tr><td>Average</td><td>O(n log n)</td><td>Random data</td></tr>
 *   <tr><td>Worst</td><td>O(n²)</td><td>Already sorted, bad pivot</td></tr>
 * </table>
 * 
 * <h3>Space Complexity:</h3>
 * <ul>
 *   <li>O(log n) for recursion stack (average case)</li>
 *   <li>O(n) in worst case</li>
 *   <li>In-place sorting (no additional array needed)</li>
 * </ul>
 * 
 * <h3>Characteristics:</h3>
 * <ul>
 *   <li><b>Family</b>: Divide and Conquer</li>
 *   <li><b>In-place</b>: Yes</li>
 *   <li><b>Stable</b>: No (relative order of equal elements may change)</li>
 *   <li><b>Adaptive</b>: No</li>
 * </ul>
 * 
 * <h3>Pivot Selection Strategies:</h3>
 * <ul>
 *   <li><b>First/Last</b>: Simple but poor on sorted data</li>
 *   <li><b>Middle</b>: Better for sorted data</li>
 *   <li><b>Random</b>: Best average-case behavior</li>
 *   <li><b>Median-of-three</b>: Good practical choice</li>
 * </ul>
 * 
 * @param <T> the type of elements to be sorted, must be Comparable
 * @author Justin Wetherell
 * @see <a href="http://en.wikipedia.org/wiki/Quick_sort">Wikipedia - QuickSort</a>
 */
public class QuickSort<T extends Comparable<T>> {

    private static final Random RANDOM = new Random();

    /**
     * Enumeration of pivot selection strategies.
     * 
     * <p>The choice of pivot can significantly affect performance:</p>
     * <ul>
     *   <li>FIRST - Simple but O(n²) on sorted arrays</li>
     *   <li>MIDDLE - Better for sorted arrays</li>
     *   <li>RANDOM - Best average-case guarantees</li>
     * </ul>
     */
    public static enum PIVOT_TYPE {
        /** Select first element as pivot. */
        FIRST, 
        /** Select middle element as pivot. */
        MIDDLE, 
        /** Select random element as pivot. */
        RANDOM
    };

    public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

    private QuickSort() {
    }

    /**
     * Sorts an array using the QuickSort algorithm.
     *
     * @param <T> the type of elements in the array
     * @param type the pivot selection strategy to use
     * @param unsorted the array to be sorted (modified in-place)
     * @return the sorted array (same reference as input)
     */
    public static <T extends Comparable<T>> T[] sort(PIVOT_TYPE type, T[] unsorted) {
        int pivot = getRandom(unsorted.length);
        sort(pivot, 0, unsorted.length - 1, unsorted);
        return unsorted;
    }

    /**
     * Recursive sort helper that partitions and sorts sub-arrays.
     *
     * @param <T> the type of elements in the array
     * @param pivotIndex the relative pivot index within the current range
     * @param start the start index of the sub-array
     * @param finish the end index of the sub-array
     * @param unsorted the array being sorted
     */
    private static <T extends Comparable<T>> void sort(int pivotIndex, int start, int finish, T[] unsorted) {
        pivotIndex = start + pivotIndex;
        T pivot = unsorted[pivotIndex];
        int s = start;
        int f = finish;
        while (s <= f) {
            while (unsorted[s].compareTo(pivot) < 0)
                s++;
            while (unsorted[f].compareTo(pivot) > 0)
                f--;
            if (s <= f) {
                swap(s, f, unsorted);
                s++;
                f--;
            }
        }
        if (start < f) {
            pivotIndex = getRandom((f - start) + 1);
            sort(pivotIndex, start, f, unsorted);
        }
        if (s < finish) {
            pivotIndex = getRandom((finish - s) + 1);
            sort(pivotIndex, s, finish, unsorted);
        }
    }

    /**
     * Gets a pivot index based on the configured pivot selection strategy.
     *
     * @param length the length of the current sub-array
     * @return the selected pivot index
     */
    private static final int getRandom(int length) {
        if (type == PIVOT_TYPE.RANDOM && length > 0)
            return RANDOM.nextInt(length);
        if (type == PIVOT_TYPE.FIRST && length > 0)
            return 0;
        else
            return length / 2;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param <T> the type of elements in the array
     * @param index1 the first index
     * @param index2 the second index
     * @param unsorted the array containing elements to swap
     */
    private static <T extends Comparable<T>> void swap(int index1, int index2, T[] unsorted) {
        T index2Element = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = index2Element;
    }
}
