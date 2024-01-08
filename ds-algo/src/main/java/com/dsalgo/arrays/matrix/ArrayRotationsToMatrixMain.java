package com.dsalgo.arrays.matrix;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 *
 */
@Slf4j
public class ArrayRotationsToMatrixMain {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] letRotationsArray = {2, 3};

        int[][] solve = solve(array, letRotationsArray);

        MatricesUtil.printMatrix("Final Matrix : ", solve);
    }

    public static int[][] solve(int[] array, int[] letRotationsArray) {

        int[][] output = new int[letRotationsArray.length][array.length];

        for(int i=0; i<letRotationsArray.length; i++){

            int[] dupArray = Arrays.copyOf(array, array.length);

            int[] rotatedArray = leftRotate(dupArray, letRotationsArray[i]);

            for(int j=0; j<dupArray.length; j++){
                output[i][j] = rotatedArray[j];
            }
        }
        return output;
    }

    private static int[] leftRotate(int[] array, int rotations){

        if(array.length <= rotations){
            rotations = rotations % array.length;
        }

        // reverse
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

        return array;
    }


}
