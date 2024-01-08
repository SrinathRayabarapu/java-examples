package com.dsalgo.recursion;

/**
 * print numbers without any loops, using recursion.
 *
 * @author Srinath.Rayabarapu
 */
public class PrintNumbersRecursivelyMain {

    public static void main(String[] args) {
        printNumbers(1);
    }

    private static void printNumbers(int i) {
        if(i > 10){
            return;
        }
        System.out.println(i);
        printNumbers(i+1);
    }
}