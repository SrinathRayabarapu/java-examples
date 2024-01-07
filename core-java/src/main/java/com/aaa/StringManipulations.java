package com.aaa;

import java.util.List;

public class StringManipulations {

    public static String breakStringMeaningfully(final String inputString, final List<String> dictionary) {

        if (inputString == null) {
            return "";
        }

        String returnString = "";

        // version: 1
        /*
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i; j <= inputString.length(); j++) {
                if (dictionary.contains(inputString.substring(i, j))) {
                    if (returnString.equals("")) {
                        returnString = inputString.substring(i, j);
                    } else {
                        returnString = returnString + " " + inputString.substring(i, j);
                    }
                    i = j;
                }
                System.out.println(inputString.substring(i, j));
            }
        }
        */

        // version: 2
        int t = 0;
        for (int i = 0; i <= inputString.length(); i++) {
            if (dictionary.contains(inputString.substring(t, i))) {
                if (returnString.equals("")) {
                    returnString = inputString.substring(t, i);
                } else {
                    returnString = returnString + " " + inputString.substring(t, i);
                }
                t = i;
            }
        }

        return returnString;
    }

}
