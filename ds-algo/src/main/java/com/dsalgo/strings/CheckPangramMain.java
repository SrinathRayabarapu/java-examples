package com.dsalgo.strings;

/**
 * given a sentence, check whether it'a pangram
 *
 * Pangram - a sentence which is formed with all 26 alphabets.
 *
 * Useful -
 * 'a' - 'z' ASCII values range 97-122
 * 'A' - 'Z' ASCII values range 65-90
 *
 * @author Srinath.Rayabarapu
 */
public class CheckPangramMain {

    public static void main(String[] args) {

        String inputStr = "the quick brown fo jumps over the lazy dog";

        boolean[] markArray = new boolean[26];
        int index = 0;
        for (char c : inputStr.toCharArray()){
            if('A' <= c && c <= 'Z'){
                index = c - 'A';
            } else if('a' <= c && c <= 'z'){
                index = c - 'a';
            }
            markArray[index] = true;
        }

        boolean isPangram = true;

        for (boolean b : markArray){
            if(!b){
                isPangram = false;
                break;
            }
        }

        if(isPangram)
            System.out.println("Input string is Pangram");
        else
            System.out.println("Input string is NOT Pangram");

        for (int i=0; i< markArray.length; i++){
            if(!markArray[i]){
                System.out.print("Missing chars : " + (char)(i + 97) + " ");
            }
        }

    }

}