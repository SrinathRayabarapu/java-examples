package com.puzzles;

/**
 * given two numbers, swap them without using third temp number
 *
 * @author Srinath.Rayabarapu
 */
public class SwapTwoNumbersMain {

    public static void main(String[] args) {
        usingAddSub(10, 20);
        usingXOR(10, 20);
    }

    // https://www.javatpoint.com/java-program-to-swap-two-numbers-using-bitwise-operator
    private static void usingXOR(int a, int b) {
        System.out.println("a: " + a + ", b: " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + ", b: " + b);
    }

    private static void usingAddSub(int a, int b) {
        System.out.println("a: " + a + ", b: " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a: " + a + ", b: " + b);
    }

}
