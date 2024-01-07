package com.core.io;

import java.io.*;

public class WordReplace {

	public static void main(String args[]) {

		try {
			File file = new File("C:\\myFile.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "", oldtext = "";

			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r\n";
			}

			reader.close();

			int num = args.length;
			if (num > 0) {
				System.out.println("The values entered in   command line are:");
				for (int i = 0; i < num; i++) {
					System.out.println("Argument " + (i + 1) + " = " + args[i]);
				}
			} else {
				System.out
						.println("No values has been entered at the command line.");
			}

			// To replace a word in a file
			String newtext = oldtext.replaceAll(args[0], args[1]);

			FileWriter writer = new FileWriter("C:\\myFile.txt");
			writer.write(newtext);
			writer.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}