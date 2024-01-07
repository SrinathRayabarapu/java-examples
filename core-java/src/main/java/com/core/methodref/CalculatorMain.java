package com.core.methodref;

/**
 * for understanding pass by reference and pass by value
 *
 * @author Srinath.Rayabarapu
 */
public class CalculatorMain {

    public static void main(String[] args) {

        int i = 0;
        System.out.print(i++ + addMeOne(i));
        System.out.println(i);
    }

    private static int addMeOne(int i) {
        System.out.print(i++);
        return i;
    }

}
