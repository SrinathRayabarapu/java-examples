package com.dsalgo.arrays.triangle;

/**
 * given a triangle depth, print pascal triangle
 *
 * Ex: depth - 6
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 *
 * @author Srinath.Rayabarapu
 */
public class PascalTriangleMain {

    public static void main(String[] args) {

        int depth = 6;

        // printing rows
        for (int i = 0; i < depth; i++) {

            //printing spaces
            for(int j=depth; j>i; j--){
                System.out.print(" ");
            }

            int number = 1;

            for(int k=0; k<=i; k++){
                System.out.print(number+" ");
                number = number * (i - k) / (k + 1);
            }

            System.out.println();
        }

    }

}
