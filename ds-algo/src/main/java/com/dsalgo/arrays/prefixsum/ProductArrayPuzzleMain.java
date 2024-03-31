package com.dsalgo.arrays.prefixsum;

import java.util.Arrays;

public class ProductArrayPuzzleMain {

    public static void main(String[] args) {

//        int[] array = {1, 2, 3, 4, 5};

        int[] array = {5, 1, 10, 1};

        System.out.println("Original array : " + Arrays.toString(array));

        int product = 1;
        for (int i : array){
            product = product * i;
        }

        int[] prodArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            prodArray[i] = product / array[i];
        }

        System.out.println("Final product array : " + Arrays.toString(prodArray));


    }

}
