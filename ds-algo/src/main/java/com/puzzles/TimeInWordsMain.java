package com.puzzles;

import java.util.HashMap;
import java.util.Map;

/**
 * given a int hour and minute, print the time in text
 *
 * @author Srinath.Rayabarapu
 */
public class TimeInWordsMain {
	
	static Map<Integer, String> minutesMap = null;
	static {
		minutesMap = new HashMap<Integer, String>();
        minutesMap.put(1, "one minute ");
        minutesMap.put(2, "two minutes ");
        minutesMap.put(3, "three minutes ");
        minutesMap.put(4, "four minutes ");
        minutesMap.put(5, "five minutes ");
        minutesMap.put(6, "six minutes ");
        minutesMap.put(7, "seven minutes ");
        minutesMap.put(8, "eight minutes ");
        minutesMap.put(9, "nine minutes ");
        minutesMap.put(10, "ten minutes ");
        minutesMap.put(11, "eleven minutes ");
        minutesMap.put(12, "twelve minutes ");
        minutesMap.put(13, "thirteen minutes ");
        minutesMap.put(14, "fourteen minutes ");
        minutesMap.put(15, "quarter ");
        minutesMap.put(16, "sixteen minutes ");
        minutesMap.put(17, "seventeen minutes ");
        minutesMap.put(18, "eighteen minutes ");
        minutesMap.put(19, "nineteen minutes ");
        minutesMap.put(20, "twenty minutes ");
        minutesMap.put(21, "twenty one minutes ");
        minutesMap.put(22, "twenty two minutes ");
        minutesMap.put(23, "twenty three minutes ");
        minutesMap.put(24, "twenty four minutes ");
        minutesMap.put(25, "twenty five minutes ");
        minutesMap.put(26, "twenty six minutes ");
        minutesMap.put(27, "twenty seven minutes ");
        minutesMap.put(28, "twenty eight minutes ");
        minutesMap.put(29, "twenty nine minutes ");
	}
	
	public static void main(String[] args) {
		
		/*Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();*/

		int h = 11;
		int m = 49;
		
        String hour = getHourString(h);
        String minutes = null;
        if(m == 0){
        	minutes = " o' clock"; 
        	hour = hour + minutes; 
        } else if(m == 30){
        	minutes = "half past "; 
        	hour = minutes + hour ; 
        } else if(m < 30){
        	minutes = getMinutesString(m);
        	hour = minutes + "past " + hour ;
        } else{
        	minutes = getMinutesString(60-m);
        	if(h == 12){
        		h = 0;
        	}
        	hour = minutes + "to " + getHourString(h+1) ;
        }
        
        System.out.println(hour);
                
	}

	/**
	 *
	 * @param m
	 * @return
	 */
	private static String getMinutesString(int m) {
        return minutesMap.get(m);
	}

	/**
	 * @param h
	 * @return 
	 */
	private static String getHourString(int h) {
		String hour = null;
		switch (h) {
		case 1:
			hour = "one";
			break;			
		case 2:
			hour = "two";
			break;		
		case 3:
			hour = "three";
			break;			
		case 4:
			hour = "four";
			break;
		case 5:
			hour = "five";
			break;
		case 6:
			hour = "six";
			break;
		case 7:
			hour = "seven";
			break;
		case 8:
			hour = "eight";
			break;
		case 9:
			hour = "nine";
			break;
		case 10:
			hour = "ten";
			break;
		case 11:
			hour = "eleven";
			break;
		case 12:
			hour = "twelve";
			break;
		default:
			break;
		}
		return hour;
	}

}