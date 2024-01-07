package com.assignments.thoughtworks;

import java.util.List;

/**
 * Main program to run the application
 */
public class Main {

	public static void main(String[] args) {
		
		String fileName = "input.txt";
		
		ConferenceScheduler conferenceScheduler = new ConferenceScheduler();
		InputReader inputReader = new InputReader();
		
		try {
			
			//read input data from file
			List<String> talkList = inputReader.getAllTalksFromFile(fileName);
			
			//schedule talks based on their time duration
			conferenceScheduler.scheduleConference(talkList);
			
		} catch (TalkException ite) {
			System.out.println("In valid talks found : " + ite);
		} catch (Exception e) {
			System.out.println("GenericType exception : " + e);
		}
	}

}