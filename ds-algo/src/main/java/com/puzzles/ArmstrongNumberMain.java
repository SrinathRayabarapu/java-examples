package com.puzzles;

/**
 * Program to check given number is Armstrong or not
 * Idea: get each number, cube it and add it to another number then compare
 *
 * <p>
 * Def: Armstrong number is a number that is equal to the sum of cubes of its digits.
 * For example 0, 1, 153, 370, 371, 407 etc.
 * <p>
 *
 * 153 = 1(1*1*1) + 125(5*5*5) + 27(3*3*3)
 *
 * @author Srinath.Rayabarapu
 */
public class ArmstrongNumberMain {

    public static void main(String args[]) {

        int num = 153;

        int input = num; // use to check at last time
        int value = 0, remainder;

        while (num > 0) {
            remainder = num % 10;
            value += + (remainder * remainder * remainder);
            num = num / 10;
        }

        if (value == input)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not an Armstrong Number");
    }
}