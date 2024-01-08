package com.dsalgo.arrays;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * print all binary combinations in a array
 *
 * It's a Backtracking problem
 *
 * @author Srinath.Rayabarapu
 */
public class GenerateAllBitsMain {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateAllBitsMain.class);

    public static void main(String[] args) {
        int[] inputArray = new int[3];
        binary(inputArray, inputArray.length);
    }

    private static void binary(int[] inputArray, int index) {
        if(index < 1){
            LOG.info(Arrays.toString(inputArray));
        } else {
            inputArray[index-1] = 0;
            binary(inputArray, index-1);
            inputArray[index-1] = 1;
            binary(inputArray, index-1);
        }
    }

}
