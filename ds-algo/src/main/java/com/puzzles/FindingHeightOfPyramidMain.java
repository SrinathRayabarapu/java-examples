package com.puzzles;

/**
 * program to check whether with a passed number a valid pyramid can be constructible or not.
 *
 * @author Srinath.Rayabarapu
 */
public class FindingHeightOfPyramidMain {

    public static void main(String[] args) {
        new FindingHeightOfPyramidMain().findHeightOfPyramid(37);
    }

    public void findHeightOfPyramid(int inputNumber) {

        System.out.println("Input is : " + inputNumber);

        int value = 0;
        boolean isFound = false;
        for (int i = 1; value <= inputNumber; i++) {
            value = value + i;
            System.out.println(value);

            if (inputNumber == value) {
                System.out.println("Cool, we can construct a valid Pyramid! and it's height will be : " + i);
                isFound = true;
                break;
            }
        }

        if (!isFound)
            System.out.println("Oops, we cann't construct a valid Pyramid!");

    }

}