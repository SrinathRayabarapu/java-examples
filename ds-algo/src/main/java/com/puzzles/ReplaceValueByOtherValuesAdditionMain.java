package com.puzzles;

import java.util.Arrays;

/**
 * given an array, replace each element with all other elements sum.
 *
 * can do like ReplaceValueByOtherValuesMultipliedMain.java but trying a different approach here.
 *
 * @author Srinath.Rayabarapu
 */
public class ReplaceValueByOtherValuesAdditionMain {

    public static void main(String[] args) {

        int[] inputArray = {3, 6, 4, 8, 9};

        int[] target = new int[inputArray.length];
        for(int i=0; i< inputArray.length; i++){
            int count = 0;
            for(int j=0; j<inputArray.length; j++){
                if(i != j){
                    count = count + inputArray[j];
                }
            }
            target[i] = count;
        }

        System.out.println(Arrays.toString(target));
    }

}
