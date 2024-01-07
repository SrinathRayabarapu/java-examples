package com.book.tij.rtti;

import java.util.ArrayList;
import java.util.List;

class CountedInteger{
	private static long counter;
	private final long id = counter++;
	public String toString(){
		return Long.toString(id);
	}
}

public class FilledList<T> {
	private Class<T> type;
	//parameterized constructor
	public FilledList(Class<T> type){
		this.type = type;
	}
	public List<T> create(int element) throws InstantiationException, IllegalAccessException{
		
		List<T> resultList = new ArrayList<T>();
		for(int i=0; i<element; i++){
			resultList.add(type.newInstance());
		}
		return resultList;
	}
	
	public static void main(String[] args) {
		FilledList<CountedInteger> filledList = new FilledList<CountedInteger>(CountedInteger.class);
		try {
			System.out.println(filledList.create(10));
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}