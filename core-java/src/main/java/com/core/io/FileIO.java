package com.core.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIO {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("xmlconfig.properties");
		FileOutputStream fos = new FileOutputStream("copy.properties");
		int i = 0;
		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
			fos.write((char) i);
		}
	}
}
