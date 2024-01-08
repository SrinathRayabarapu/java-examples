package com.hackerrank.threeOdaysOfCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * generic program to read std input and write to std output - used for hacker rank like sites.
 *
 * @author Srinath.Rayabarapu
 */
public class HelloWorld_Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Set<String> names = new HashSet<>();
        while(scan.nextLine() != "" && scan.nextLine() != null){
            String inputString = scan.nextLine();
            names.add(inputString);
        }

        System.out.println(names);


        scan.close();
    }
}