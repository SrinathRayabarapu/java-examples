package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArrayAscDescOrderMain {

	public static void main(String[] args) {
		Integer[] points = new Integer[5];
		points[0] = 94;
		points[1] = 53;
		points[2] = 70;
		points[3] = 44;
		points[4] = 64;

		// Sort the points array, the default order is in ascending order.
		Arrays.sort(points);
		System.out.println(Arrays.toString(points));

		Arrays.sort(points, Collections.reverseOrder());
		System.out.println(Arrays.toString(points));
	}
}