package com.core.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author srayabar
 *
 */
public class StreamsForEach {
	
	public static void main(String[] args) {
		
		List<Integer> numberList = new ArrayList<Integer>();
		
		for(int i=0; i<=50; i++){
			numberList.add(i);
		}
		
		for(int i : numberList){
			System.out.println(i);		
		}
		
		System.out.println("Using forEach");
		numberList.parallelStream().forEach(i -> {
			System.out.println(i);
		});
		
		System.out.println("Using forEachOrdered");
		numberList.parallelStream().forEachOrdered(i -> {
			System.out.println(i);
		});
		
		
		
		/*
		 * use forEach for unordered calculations
		 *
		 * use forEachOrdered for ordered calculations
		 */		
	}

}





