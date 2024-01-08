package com.dsalgo.strings;

/**
 * https://www.codewars.com/kata/5596f6e9529e9ab6fb000014
 *
 * Ex:
 * "coffee", "eecoff" => 2
 * "eecoff", "coffee" => 4
 * "moose", "Moose" => -1
 * "isn't", "'tisn" => 2
 * "Esham", "Esham" => 0
 * "dog", "god" => -1
 */
public class CalculateStringRotationMain {

    public static void main(String[] args) {

        System.out.println(calculateStringRotations("coffee", "eecoff"));
        System.out.println(calculateStringRotations("eecoff", "coffee"));
        System.out.println(calculateStringRotations("moose", "Moose"));
        System.out.println(calculateStringRotations("isn't", "'tisn"));
        System.out.println(calculateStringRotations("Esham", "Esham"));
        System.out.println(calculateStringRotations("dog", "god"));

        System.out.println(calculateStringRotationsClever("coffee", "eecoff"));
    }

    // approach 1: check length and forward input string by a char and try to match and repeat till it matches
    // or reaches to the end
    public static int calculateStringRotations(String inputString, String targetString){

        if(inputString == null || targetString == null)
            return -1;

        if(inputString.length() != targetString.length())
            return -1;

        if(inputString.equals(targetString))
            return 0;

        char[] inputCharArray = inputString.toCharArray();
        for (int i = 0; i < inputCharArray.length; i++) {
            inputString = inputString.charAt(inputString.length()-1) + "" + inputString.substring(0, inputString.length()-1);
            if(inputString.equals(targetString)){
                return i+1;
            }
        }

        return -1;
    }

    public static int calculateStringRotationsClever(String inputString, String targetString){
        return inputString.length() != targetString.length() ? -1 : (targetString + targetString).indexOf(inputString);
    }

}
