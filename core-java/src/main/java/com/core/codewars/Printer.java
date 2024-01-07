package com.core.codewars;

public class Printer {

    public static String printerError(String inputString) {

        int numer = 0;
        for(char c : inputString.toCharArray()){
            if(c > 109){
                numer++;
            }
        }

        int denom = inputString.length();
        return numer+"/"+denom;
    }

    // best solution from Kata
    public static String bestPrinterError(String s) {
        return s.replaceAll("[a-m]", "").length() + "/" + s.length();
    }

}