package com.core.codewars;

/**
 * https://www.codewars.com/kata/54ba84be607a92aa900000f1/train/java
 */
public class Isogram {
    public static boolean  isIsogram(String str) {

        if(str.length() == 0){
            return true;
        }

        int[] charArray = new int['z'+1];

        for(char c : str.toLowerCase().toCharArray()){
            charArray[c] = charArray[c] + 1;
            if(charArray[c] > 1){
                return false;
            }
        }
        return true;
    }

    // Best solution from Kata
    public static boolean  bestIsIsogram(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }

}
