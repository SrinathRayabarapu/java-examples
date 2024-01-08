package com.hackerrank.threeOdaysOfCode;

import java.util.Scanner;

/*
 * 	9 6 2015
	6 6 2015
 */
public class Solution_26 {

	public static void main(String[] args) {
		
		//System.out.println("1");
		
		Scanner scan = new Scanner(System.in);
		int d = scan.nextInt();
		int m = scan.nextInt();
		int y = scan.nextInt();
		
		//date returned
		//System.out.println(d);
		//System.out.println(m);
		//System.out.println(y);
		
		int d1 = scan.nextInt();
		int m1 = scan.nextInt();
		int y1 = scan.nextInt();
		
		//due date 
		//System.out.println(d1);
		//System.out.println(m1);
		//System.out.println(y1);
		
		/*Calendar returnDate = GregorianCalendar.getInstance();		
		returnDate.set(y, m, d);
		
		
		Calendar dueDate = GregorianCalendar.getInstance();
		dueDate.set(y1, m1, d1);*/
		
		long fine = 0;
		if( y - y1 < 0){
			
		} else if(y - y1 > 0){
			fine = 10000;
		} else if(m-m1 > 0){
			fine = (m-m1) * 500;
		} else if(d-d1 > 0){
			fine = (d -d1) * 15;
		}
		
		System.out.println(fine);
		
	}	
	
}
