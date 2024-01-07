package com.core.codewars;

public class PangramChecker {

    public boolean check(String sentence){

        String abc = "abcdefghijklmnopqrstuvwxyz";
        for(char c : abc.toCharArray()){
            if(!sentence.toLowerCase().contains(c + "")){
                return false;
            }
        }

        return true;
    }

    // best solution from Kata
    public boolean bestCheck(String sentence){
        for (char c = 'a'; c<='z'; c++)
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;

    }

}
