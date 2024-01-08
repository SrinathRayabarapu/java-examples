package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
 * <p>
 * An element is a leader if it is strictly greater than all the elements to its right side.
 * <p>
 * NOTE:The rightmost element is always a leader.
 */
@Slf4j
public class LeadersInAnArrayMain {

    public static void main(String[] args) {
        int[] inputArray = {16, 17, 4, 3, 5, 2};

        int[] leaders = findLeaders(inputArray);

        log.info("Leaders array : {}", Arrays.toString(leaders));
    }

    private static int[] findLeaders(int[] inputArray) {

        List<Integer> list = new ArrayList<>();

        if(inputArray.length < 2){
            return inputArray;
        } else {
            int temp = inputArray[inputArray.length-1];

            list.add(temp);

            for (int i = inputArray.length-1; i >= 0 ; i--) {
                if(temp < inputArray[i]){
                    temp = inputArray[i];
                    list.add(temp);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}