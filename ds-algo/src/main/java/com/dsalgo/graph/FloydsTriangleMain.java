package com.dsalgo.graph;

/**
 * print floyds triangle -
 *
 * 1
 * 23
 * 456
 * 78910
 * ......
 *
 * @author Srinath.Rayabarapu
 */
public class FloydsTriangleMain {

    public static void main(String[] args) {
        int counter = 1;
        for (int i = 0; i < 10; i++) { // rows
            for (int j = 0; j < i; j++) { //elements in each row
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println("");
        }
    }

}