package com.puzzles;

public class PowerFunctionMain {

    public static void main(String[] args) {
        System.out.println(power(3, 9));
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param x
     * @param y
     * @return
     */
    public static long power(int x, int y){
        long power = 1l;
        for (int i = 0; i < y; i++) {
            power = power * x;
        }
        return power;
    }

    /**
     * TC: O(log n)
     * SC: O(1)
     *
     * @param x
     * @param y
     * @return
     */
    public static long power1(int x, int y){
        long power = 1l;

        while(y > 0){
            System.out.println("x : " + x);
            System.out.println("y : " + y);

            if(y % 2 != 0){
                power = power * x;
            }
            x = x * x;
            y = y/2;

            System.out.println("power : " + power);
        }
        return power;
    }


}
