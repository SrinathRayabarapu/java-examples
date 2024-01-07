package com.core.logicaloperators;

/**
 * XOR : A or B but not both!
 *
 */
public class XORMain {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        if( a == 10 ^ b == 20){
            System.out.println("Any one is fine!!");
        } else {
            System.out.println("Not both please!!");
        }

    }
}
