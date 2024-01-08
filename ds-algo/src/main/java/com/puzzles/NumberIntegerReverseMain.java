package com.puzzles;

/**
 * Program to reverse an integer
 * <p>
 * logic : get divisor by 10 and add it reverse number * 10
 *
 * @author Srinath.Rayabarapu
 */
public class NumberIntegerReverseMain {

    public static void main(String[] args) {
        int a = 123456789;

        // possible integer flow with this approach
        approach1(a);

        // using long type to handle that
        approach2(Integer.MAX_VALUE);
    }

    private static void approach2(int value) {
        System.out.println("Input : " + value);
        long reverse = 0;
        while(value > 0){
            reverse = (reverse * 10) + (value % 10);
            value = value/10;
        }
        System.out.println("Reversed2 : " + reverse);
    }

    private static void approach1(int a) {
        System.out.println("Input : " + a);
        int reverse = 0;
        while (a != 0) {
            reverse = (reverse * 10) + (a % 10);
            a = a / 10;
        }
        System.out.println("Reversed : " + reverse);
    }

}