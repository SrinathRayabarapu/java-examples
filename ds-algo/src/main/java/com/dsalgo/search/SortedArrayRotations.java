package com.dsalgo.search;

/**
 * circularly sorted array - find number of times a circular sorted array rotated
 * <p>
 * Time COmplexity : O(log n) - Using Binary search tree
 *
 * @author Srinath.Rayabarapu
 */
public class SortedArrayRotations {

    public static void main(String[] args) {
        //it's rotated 3 times left rotated
        int[] array = {8, 9, 10, 2, 3, 4, 5, 6, 7};
        System.out.println("Rotations - " + findNumberOfRotations(array, array.length));
    }

    public static int findNumberOfRotations(int[] array, int len) {

        int start = 0, end = len - 1;
        while (start <= end) {

            //case 1: already in sorted - hence return start - default 0
            if (array[start] <= array[end]) {
                return start;
            }

            int mid = start + (end - start) / 2;
            System.out.println("mid-" + mid);

            //magic - way to find prev and next indices
            int prev = (mid + len - 1) % len;
            int next = (mid + 1) % len;
            System.out.println("prev-" + prev + ",next-" + next);

            //case 2: pivot element property
            if (array[mid] <= array[next] && array[mid] <= array[prev]) {
                return mid;
            }
            //check pivot element is greater than end - if yes then it's proper - check other side
            if (array[mid] <= array[end]) {
                end = mid - 1;
            }
            //check start is greater than pivot then it's proper - check other side
            if (array[mid] >= array[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }

}