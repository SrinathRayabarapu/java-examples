package com.google.codejam;

import java.io.*;
import java.util.Scanner;

public class MagicTrickMain {

	/**
	 * Main method to call a static function which unveils the magic
	 * @param args
	 */
	public static void main(String[] args) {
		
		unveilMagicTrick("MagicTrickMain-input.txt", "MagicTrickMain-output.txt");

	}
	
	/**
	 * method to read the input file then find out the magic and write out the result to a file
	 * 
	 * @param inputFileName
	 * @param outputFileName 
	 * 
	 */
	private static void unveilMagicTrick(String inputFileName, String outputFileName) {
		
		Scanner scanner = null;
		BufferedWriter out = null;
		try {
			
			scanner = new Scanner(new File(inputFileName));
			FileWriter fstream = new FileWriter(outputFileName);
			out = new BufferedWriter(fstream);
			
			StringBuffer resultBuffer = new StringBuffer();
			int noOfTestCases = Integer.parseInt(scanner.nextLine());
//			System.out.println("Number of testcases :"+noOfTestCases);
			
			// condition check for no. of testcases
			if(!(1 <= noOfTestCases && noOfTestCases <= 100)){
//				System.out.println("No. of testcases are violating the limit, exiting the program!");
				return ;
			}
				
			int testCaseLineCount = 10;
			// iterating for each testcase
			for(int i=1; i<=noOfTestCases; i++){
				
				int lineCounter = 1, firstArrangeLine = 0, secondArrangeLine = 0;
				String[] firstArrangement = new String[4], secondArrangement = new String[4];
				int matrixCounter = 0;
				
				// filling the arrangements
				while(lineCounter <= testCaseLineCount){
					
					if(lineCounter == 1){
						firstArrangeLine = Integer.parseInt(scanner.nextLine());
//						System.out.println("firstArrangeLine:"+firstArrangeLine);
					}
					if(lineCounter == 6){
						secondArrangeLine = Integer.parseInt(scanner.nextLine());
//						System.out.println("secondArrangeLine:"+secondArrangeLine);
						matrixCounter = 0;
					}
					
					if(2 <= lineCounter && lineCounter <= 5){
						firstArrangement[matrixCounter] = scanner.nextLine();
						matrixCounter++;
					}
					if(7 <= lineCounter && lineCounter <= 10){
						secondArrangement[matrixCounter] = scanner.nextLine();
						matrixCounter++;
					}
					lineCounter++;
				}
				
				// condition check for row line numbers
				if(!((1<= firstArrangeLine && firstArrangeLine <= 4) && 
						(1<= secondArrangeLine && secondArrangeLine <= 4))){
//					System.out.println("Either of the 2 answers are violating the row number limit!");
					return ;
				}
				
				String[] firstArrangeLineData = firstArrangement[firstArrangeLine-1].split(" ");
				String[] secondArrangeLineData = secondArrangement[secondArrangeLine-1].split(" ");
				
				int matchCounter = 0;
				int matchedResult = 0;
				for(int j=0; j<firstArrangeLineData.length; j++){
					for(int k=0; k<secondArrangeLineData.length; k++){
						if(Integer.parseInt(firstArrangeLineData[j]) == Integer.parseInt(secondArrangeLineData[k])){
							matchedResult = Integer.parseInt(firstArrangeLineData[j]);
							matchCounter++;
						}
					}
				}
				
				if(matchCounter == 1){
//					System.out.println("Case #"+i+": "+matchedResult);
					resultBuffer.append("Case #"+i+": "+matchedResult+"\n");
				}else if(matchCounter > 1){
//					System.out.println("Case #"+i+": Bad magician!");
					resultBuffer.append("Case #"+i+": Bad magician!"+"\n");
				}else if(matchCounter == 0){
//					System.out.println("Case #"+i+": Volunteer cheated!");
					resultBuffer.append("Case #"+i+": Volunteer cheated!"+"\n");
				}
			}
			
			// writing to file
			out.write(resultBuffer.toString());
			
		} catch (NumberFormatException e) {
			System.out.println("wrong with input file data!");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("input text file is not present!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("problem while writing to output file!");
			e.printStackTrace();
		} finally{
			if(scanner != null)
				scanner.close();
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}