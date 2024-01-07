package com.bmc.ninjapuzzles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * bmc ninza puzzle to read list of teams with their score separated by ':' to
 * calculated how many team scored centuries and write o/p to output file.
 *
 * @author Srinath.Rayabarapu
 */
public class NoCentury {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	static String inputFile = "com\\bmc\\ninjapuzzles\\input.txt";
	static String outputFile = "com\\bmc\\ninjapuzzles\\output.txt";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NoCentury noCenturyObj = new NoCentury();
		List<String> inputFileDataList = noCenturyObj.getInputFileDataList(inputFile);
		
		LOG.info("{}", inputFileDataList.size());
		
		int noCenturyCountries = noCenturyObj.findNoCenturyCountries(inputFileDataList);
		LOG.info("{}", noCenturyCountries);
		
		boolean isSuccessful = noCenturyObj.writeOutputDataToFile(noCenturyCountries, outputFile);
		if(isSuccessful)
			LOG.info("Successfully written to output file");
	}
	
	private boolean writeOutputDataToFile(int noCenturyCountries, String fileName) {
		boolean result = false;
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\"+fileName);
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(file);
	        writer.write(noCenturyCountries+"");
	        result = true;
	    } catch (IOException e) {
	        e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
	    } finally {
	        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
	    }
	    
		return result;
	}

	private int findNoCenturyCountries(List<String> inputFileDataList) {
		
		int century = 100;
		Set<String> countriesSet = new HashSet<>();

		for (String dataLine : inputFileDataList) {
			String[] split = dataLine.split(":");

			if (split.length == 2 && Integer.parseInt(split[1].trim()) >= century) {
				countriesSet.add(split[0]);
			}
		}

		return countriesSet.size();
		
	}

	/**
	 * Reads a file and returns a List with the file data
	 * 
	 * @param inputFile
	 * @return List<Double>
	 */
	private List<String> getInputFileDataList(String inputFile) {

		String token = null;
		List<String> fileDataList = new ArrayList<>();
		BufferedReader reader = null;

		try {
			System.out.println("input file is:"+inputFile);
			InputStream inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(inputFile);
			
			reader = new BufferedReader(new InputStreamReader(inputStream));

			while ((token = reader.readLine()) != null) {
				fileDataList.add(token);
			}
			
		} catch (IOException e) {
			System.out.println("Something went wrong while reading from Input.txt");
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ignore) {
				// Ignore the exception
			}
		}
		return fileDataList;
	}

}
