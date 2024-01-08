package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * given an array, rotate the array k number of times in both clockwise and anti-clockwise directions
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class ArrayKLeftRightRotationsMain {

    public static void main(String[] args) {

        int[] temp = {1, 2, 3, 4, 5};

		log.info("Given array : {}", Arrays.toString(temp));

        // clock wise
        rotateRightOk(temp, 3);
        log.info("Rotated right array : {}", Arrays.toString(temp));

        // anti-clock wise
        rotateLeftOk(temp, 3);
		log.info("Rotated left array : {}", Arrays.toString(temp));

        // clock wise
        rotateRightGood(temp, 3);
        log.info("Rotated right array : {}", Arrays.toString(temp));

        // anti-clock wise
        rotateLeftGood(temp, 3);
        log.info("Rotated left array : {}", Arrays.toString(temp));

    }

    private static void rotateLeftGood(int[] array, int rotations) {
        // reverse the array
        // reverse 0, n-k-1 numbers
        // reverse n-k, n-1 numbers

        if(array.length <= rotations){
            rotations = rotations % array.length;
        }

        // reverse the array
        int i=0;
        int j=array.length-1;
        while(i < j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // reverse(0, length-k-1)
        i=0;
        j=array.length-rotations-1;
        while(i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // reverse(length-k, length-1)
        i=array.length-rotations;
        j=array.length-1;
        while(i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param inputArray
     * @param rotations
     */
    private static void rotateRightGood(int[] inputArray, int rotations) {
        // reverse the array
        // reverse 0, k-1 numbers
        // reverse k, n-1 numbers

        if(inputArray.length < rotations){
            rotations = rotations%inputArray.length;
        }

        // reverse the array - n/2
        int i=0, j=inputArray.length-1;
        while(i < j){

            int temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;

            i++;
            j--;
        }

        // reverse 0,rotations-1 of the array
        i=0;
        j=rotations-1;

        while(i < j){

            int temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;

            i++;
            j--;
        }

        // reverse rotations,inputArray.length-1 of the array
        i=rotations;
        j=inputArray.length-1;

        while(i < j){

            int temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;

            i++;
            j--;
        }

    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param input
     * @param rotations
     */
    private static void rotateRightOk(int[] input, int rotations) {
        while (rotations-- > 0) {
            int temp = input[input.length - 1];
            for (int i = input.length - 2; i >= 0; i--) {
				input[i+1] = input[i];
            }
			input[0] = temp;

			log.info(Arrays.toString(input));
        }
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param temp
     * @param rotations
     */
    private static void rotateLeftOk(int[] temp, int rotations) {
        while (rotations-- > 0) {
            int tp = temp[0];
            for (int j = 0; j < temp.length - 1; j++) {
                temp[j] = temp[j + 1];
            }
            temp[temp.length - 1] = tp;

			log.info(Arrays.toString(temp));
        }
    }

}