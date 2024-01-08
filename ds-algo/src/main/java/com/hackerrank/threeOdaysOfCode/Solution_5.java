package com.hackerrank.threeOdaysOfCode;

import java.util.Scanner;

public class Solution_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int highSum = -999999999;
        int tempSum = 0;
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
            	if(i+2 < arr.length && j+2 < arr[i].length){
            		tempSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
            		if(highSum < tempSum){
            			highSum = tempSum; 
            		}
            	}
            }
        }
        System.out.println(highSum);
    }
}