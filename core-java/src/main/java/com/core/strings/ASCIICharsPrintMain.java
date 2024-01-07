package com.core.strings;

/**
 * given a string, print their ASCII values.
 *
 * @author Srinath.Rayabarapu
 */
public class ASCIICharsPrintMain {

    public static void main(String[] args) {
        String input = "AZazhey pilla";
        for (int i: input.toCharArray()) {
            System.out.println(i);
        }
    }
}
