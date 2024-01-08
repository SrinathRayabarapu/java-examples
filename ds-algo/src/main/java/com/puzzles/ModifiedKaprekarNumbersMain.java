package com.puzzles;

import java.util.Scanner;

/**
 * TODO: refine the code and delete scanner dependencies
 *
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 *
 * @author Srinath.Rayabarapu
 */
public class ModifiedKaprekarNumbersMain {
	
	public static void main(String[] args) {
		System.out.println(" ");
		Scanner in = new Scanner(System.in);
        long from = in.nextLong();
        long to = in.nextLong();
        String answer = "";
        
        for(long i=from; i<=to; i++){        	
        	answer = answer + calculateSomething(i);        	
        }
        
        if(answer.length() == 0){
        	System.out.println("INVALID RANGE");
        } else {
        	System.out.println(answer.trim());
        }
        
        in.close();
	}

	/**
	 * @param i
	 */
	private static String calculateSomething(long i) {
		long a;
		long b;
		a = (i * i);
		b = a;
		
		int length = findLength(i);
		
		for(int j=1; j<=length; j++){
			
			String xyz = (b+"").substring((b+"").length()-j, (b+"").length());
			
			String abc = (b+"").substring(0, (b+"").length()-j);
			
			if(abc.length() == 0 ){
				abc = "0";
			}
			
			if(xyz.length() == 0){
				xyz = "0";
			}
			
			if(xyz.length() == length && (abc.length() == length || abc.length() == length-1)){
				if(i == (Long.parseLong(abc)+Long.parseLong(xyz))){
					return (i + " ");					
				}
			}
		}
		return "";
	}
	
	public static int findLength(long a){
		int length = 0;
    	while(a != 0){
    		a = a / 10;
    		length++;
    	}
		return length; 
	}
	
}