package com.core.codewars;

public class Troll {

    public static String disemvowel(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

    // best solution from Kata
    public static String bestDisemvowel(String Z) {
        return Z.replaceAll("(?i)[aeiou]" , "");
    }

}
