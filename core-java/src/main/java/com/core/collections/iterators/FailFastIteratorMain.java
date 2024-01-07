package com.core.collections.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Below classes use FailFast Iterators:
 * ArrayList, HashSet, HashMap etc
 * 
 * @author Srinath.Rayabarapu
 */
public class FailFastIteratorMain {

	public static void main(String[] args) {
		
		List<String> stringList = new ArrayList<>();
		stringList.add("abc1");
		stringList.add("abc2");
		stringList.add("abc3");
		
		Iterator<String> iterator = stringList.iterator();
		while(iterator.hasNext()){
			stringList.add("abc4");
			//iterator detects change in base list and throw ConcurrentModificationException
			//iterator.next();
		}
	}
}