package com.dsalgo.strings;

/**
 * given two strings, find longest common suffix.
 *
 * @author Srinath.Rayabarapu
 */
public class CommonLongestSuffixMain {

    public static void main(String[] args) {

        findCommonLongestSuffix("Cornfield, Minefield");

    }

    private static void findCommonLongestSuffix(String inputString) {

        String[] split = inputString.split(",");
        String one = split[0], second = split[1];
        int i = 0;

        while ((one.length()-1)-i >= 0 && (second.length()-1)-i >= 0){
            if(one.charAt((one.length()-1)-i) != second.charAt((second.length()-1)-i)){
                break;
            }
            i++;
        }

        if( i-1 < 0){
            System.out.println("NULL");
        } else {
            System.out.println(one.substring(i-1, one.length()));
        }

    }

}