package com.aaa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Staircase {
	
	public static void main(String[] args) {
		
		int[] sds = {2231221};
		
		findFrequencyDistribution(sds);

	}
	
	

	   static String[] findFrequencyDistribution(int[] numbers) {
	        
	        String[] answerArray = new String[numbers.length];
	        Map<Integer, String> map = new HashMap<>();
	        
	        for (int i = 0; i < numbers.length; i++) {
	            
	            int count = 0;
	            String occurences = "";
	            for (int j = 0; j < numbers.length; j++) {
	                if (numbers[i] == numbers[j]){
	                    count++;
	                    if(occurences == ""){
	                        occurences = j + "";
	                    }else{
	                        occurences = occurences + ":" + j; 
	                    }                    
	                }
	            }
	            if( map.get(numbers[i]) == null){
	                answerArray[i] = numbers[i] + " " + count + " "+occurences;
	                
	            }
	            map.put(numbers[i], "found");
	        }
	        
	        
	        ArrayList<String> mylist = new ArrayList<>();
	        //String[] shdsd = (String[])mylist.toArray();
	        
	        
	        return (String[]) mylist.toArray();
	    }
	   
}
