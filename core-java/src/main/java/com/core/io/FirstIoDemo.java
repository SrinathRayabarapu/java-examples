package com.core.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FirstIoDemo {
	public static void main(String[] args) throws Exception {
		// FileInputStream stream = new
		// FileInputStream("src/com/test/AccessDemo.java");

		FileInputStream stream = new FileInputStream("Properties.properties");
		FileOutputStream outputStream = new FileOutputStream("copy.properties",
				true);
		int i = 0;
		while ((i = stream.read()) != -1) {
			System.out.print((char) i);
			outputStream.write((char) i);
		}
	}
}
