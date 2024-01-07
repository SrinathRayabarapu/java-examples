package com.assignments.thoughtworks;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * class responsible for reading input data from passed file. Assumption is inout file is existing in the same package
 *
 */
public class InputReader {
	
	public List<String> getAllTalksFromFile(String fileName) throws TalkException {
		
		List<String> allTalksList = new ArrayList<>();
		
		try {
			
			// Open the file
			InputStream resourceAsStream = this.getClass().getResourceAsStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
			String strLine = br.readLine();
			
			while (!(Objects.isNull(strLine) || strLine.isEmpty())) {
				allTalksList.add(strLine);
				strLine = br.readLine();
			}
			
			br.close();
			resourceAsStream.close();
			
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		return allTalksList;
	}

}
