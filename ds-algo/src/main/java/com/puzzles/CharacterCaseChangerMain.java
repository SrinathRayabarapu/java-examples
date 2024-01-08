package com.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write an application that reads a sentence and prints out the sentence with
 * all upper case letters changed to lowercase and all lower case letters changed to uppercase
 *
 * @author Srinath.Rayabarapu
 */
public class CharacterCaseChangerMain {

    public static void main(String[] a) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = null;
        System.out.println("Enter any String  ");
        try {
            st = br.readLine();
            // String st="Welcome To Java World";
        } catch (IOException ioe) {
            //
        }

        System.out.println("Actual string     : " + st);
        System.out.print("\nConverted String  :");
        uppercase(st);
        System.out.println();
    }

    static void uppercase(String str) {
        int i;

        for (i = 0; i < str.length(); i++) {

            if ((Character.isWhitespace(str.charAt(i)) == true))
                System.out.print(" ");

            if ((Character.isUpperCase(str.charAt(i)) == true))
                System.out.print(Character.toLowerCase(str.charAt(i)));

            if ((Character.isLowerCase(str.charAt(i)) == true))
                System.out.print(Character.toUpperCase(str.charAt(i)));
        }
    }

}