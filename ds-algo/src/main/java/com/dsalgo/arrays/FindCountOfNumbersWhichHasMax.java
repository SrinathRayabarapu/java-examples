package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * scaler problem - given an array of integers size n, find count of numbers which has atleast a number greater
 */
@Slf4j
public class FindCountOfNumbersWhichHasMax {

    public static void main(String[] args) {

        // answer should be 6
        int[] array = {-1, 3, 0, 4, 8, -9, 8, 7};

        int count = findCountOfNumbers(array);
        log.info("Count is : {}", count);
    }

    private static int findCountOfNumbers(int[] array) {

        int max = array[0];
        int maxCount = 0;

        for (int i = 0; i < array.length; i++) {
            if(max < array[i]){
                max = array[i];
            } else if (max == array[i]){
                maxCount++;
            }
        }

        return array.length - maxCount;
    }

}
