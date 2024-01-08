package com.puzzles;

import java.util.stream.IntStream;

/**
 * Traditional FizzBuzz program where we print 'FIZZ' if a number is multiple of 3 and 'BUZZ' if it is a multiple of 5 and
 * 'FIZZBUZZ' if it is a multiple of both!
 *
 * @author Srinath.Rayabarapu
 */
public class FizzBuzzMain {

    public static void main(String[] args) {

        IntStream
                .range(1, 25) //second parameter is exclusive!
                .forEach( i -> {
                    if(i%3 == 0 && i%5 ==0)
                        System.out.println("FIZZBUZZ");
                    else if(i%5 == 0)
                        System.out.println("BUZZ");
                    else if(i%3 == 0)
                        System.out.println("FIZZ");
                    else
                        System.out.println(i);
                });
    }

}
