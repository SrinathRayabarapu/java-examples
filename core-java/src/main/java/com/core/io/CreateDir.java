package com.core.io;

import java.io.File;
import java.io.IOException;

public class CreateDir {

	public static void main(String[] args) throws IOException {
		doCreateDir();
		File f = new File("C:/dir1/dir2/dir3/helloworld.txt");

		if (!f.exists()) {
			f.createNewFile();
			System.out.println("New file \"helloworld.txt\" has been created to the current directory");
		}
	}

	private static void doCreateDir() {
		String newDir = "c:/dir1/dir2/dir3/dir4";
		boolean success = (new File(newDir)).mkdirs();

		if (success) {
			System.out.println("Successfully created directory: " + newDir);
		} else {
			System.out.println("Failed to create directory: " + newDir);
		}
	}
}
