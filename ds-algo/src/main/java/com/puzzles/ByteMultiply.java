package com.puzzles;

/* Write a console program to define and initialize a variable of type byte to 1, and then successively 
 * multiply it by 2 and display its value 8 times. Explain the reason for the last value 
 */
class Bytes {
	byte byte_var = 1;

	void multiply() {
		for (int i = 1; i <= 8; i++) {
			byte_var = (byte) (2 * byte_var);
			System.out.println(byte_var);
		}
	}
}

public class ByteMultiply {
	public static void main(String[] ar) {
		Bytes by = new Bytes();
		by.multiply();
	}
}

/*
 * OUTPUT: it displays 0 as the output for the last iteration this is because
 * the byte variable can store values ranging -128 to 127
 */