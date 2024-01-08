package com.hackerrank;

import java.util.Scanner;

/**
 * 
 * 
 * 
 * https://www.hackerrank.com/challenges/java-static-initializer-block/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class StaticInitializers {
	
	private static boolean flag = false;
	private static int B = 0;
	private static int H = 0;
	
	static {
		Scanner scan = new Scanner(System.in);
		B = scan.nextInt();
		H = scan.nextInt();
		
		if(B > 0 && H > 0) {
			flag = true;
		} else {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		}
		scan.close();
	}
	
	public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class