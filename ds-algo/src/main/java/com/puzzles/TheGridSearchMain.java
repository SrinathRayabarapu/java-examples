package com.puzzles;

import java.util.Scanner;

/**
 * TODO: complete the problem
 *
 * Searching a 2D pattern in huge 2D matrix<br>
 * 
 * https://www.hackerrank.com/challenges/the-grid-search
 * 
 * @author Srinath.Rayabarapu
 */
public class TheGridSearchMain {

	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
        }
    }

}