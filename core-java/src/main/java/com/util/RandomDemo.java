package com.util;

import java.util.Random;

/**
 * generates random number within given range
 * 
 * @author srinath
 */
public class RandomDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();

		// with range
		int num = random.nextInt(10);
		System.out.println("Generated numbers are : " + num);

		// without range
		int numNoRange = random.nextInt();
		System.out.println("Generated numbers without range : " + numNoRange);
		
		String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        String a = "";
        for(int i=0; i<=15; i++) {
        	a = a + alphabet.charAt(rnd.nextInt(alphabet.length()));
        }
        System.out.println(a);
        
	}
	
}