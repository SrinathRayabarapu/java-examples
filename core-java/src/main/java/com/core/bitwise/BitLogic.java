package com.core.bitwise;

/**
 * 
 * @author srayabar
 *
 */
public class BitLogic {

	static String[] binary = {
			"0000", "0001", "0010", "0011",
			"0100", "0101", "0110", "0111",
			"1000", "1001", "1010", "1011",
			"1100", "1101", "1110", "1111"			
		};
	
	
	public static void main(String[] args) {
		int a = 3;
		int b = 6;
		int c = a | b;
		int d = a & b;
		int e = a ^ b;
		int f = (~a & b) | (a & ~b);
		int g = ~a & 0x0f;
		
		System.out.println(a+"-" + binary[a]);
		System.out.println(b+ "-" + binary[b]);
		System.out.println(c+ "-" + binary[c] );
		System.out.println(d+ "-" + binary[d]);
		System.out.println(e+ "-" + binary[e]);
		System.out.println(f+ "-" + binary[f]);
		System.out.println(g+ "-" + binary[g]);
		
	}
}
