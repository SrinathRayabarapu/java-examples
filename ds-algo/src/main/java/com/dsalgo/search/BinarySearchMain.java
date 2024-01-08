package com.dsalgo.search;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * program for binary search - Time Complexity: O(log n)
 *
 * Idea:
 * check for middle element - found return 
 * else
 * check for left subset
 * or 
 * check for right subset
 *
 * Note: Whole assumption of binary search tree works on notion - input array is sorted
 * 
 * @author Srinath.Rayabarapu
 */
public class BinarySearchMain {

	private static final Logger LOG = LoggerFactory.getLogger(BinarySearchMain.class);
	
	public static void main(String[] args) {

		int[] intArraySorted = {1, 2, 4, 6, 8, 10, 14, 21, 56, 90};

		boolean isFound = findBSRecursive(intArraySorted, 0, intArraySorted.length - 1, 10);
		LOG.info("Is element found : " + isFound);

		isFound = findBSIterative(intArraySorted, 0, intArraySorted.length - 1, 90);
		LOG.info("Is element found : " + isFound);

	}

	private static boolean findBSRecursive(int[] inputArray, int startIndex, int endIndex, int findVal) {
		if (startIndex <= endIndex) {
			int middle = startIndex + (endIndex - startIndex) / 2;
			if (inputArray[middle] == findVal) {
				return true;
			}
			if (inputArray[middle] < findVal) {
				return findBSRecursive(inputArray, middle + 1, endIndex, findVal);
			}
			return findBSRecursive(inputArray, startIndex, middle - 1, findVal);
		} else {
			return false;
		}
	}

	private static boolean findBSIterative(int[] inputArray, int startIndex, int endIndex, int findVal) {
		while (startIndex <= endIndex) {
			int middle = startIndex + (endIndex - startIndex) / 2;
			if (inputArray[middle] == findVal) {
				return true;
			} else if (inputArray[middle] < findVal) {
				startIndex = middle + 1;
			} else {
				endIndex = middle - 1;
			}
		}
		return false;
	}
	
}