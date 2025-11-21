package com.puzzles;

/**
 *
 *
 * @author - Srinath Rayabarapu
 */
public class SingleDigitCountMain {

    public static int persistence1(long n) {
        int count = 0;
        int tempNum = 1;
        while (n/10 != 0){
            tempNum = (int)(tempNum * n%10);
            n = n/10;
        }
        return count;
    }

    public static int persistence(long n) {
        if(n/10 == 0){
            return 0;
        }
        long multi = getMulti(n);
        return 1 + persistence(multi);
    }

    private static long getMulti(long n) {
        long temp = 1;
        while (n/10 != 0){
            temp = temp * (n%10);
            n = n/10;
        }
        return temp * n;
    }

    public static void main(String[] args) {
        int count = 0;
        System.out.println(persistence(4));
    }

}