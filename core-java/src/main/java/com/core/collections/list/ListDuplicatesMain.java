package com.core.collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * program to duplicates from two lists.
 * 
 * @author Srinath.Rayabarapu
 */
public class ListDuplicatesMain {
	
	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		
		List<String> list2 = new ArrayList<>();
		list2.add("f");
		list2.add("g");
		list2.add("h");
		list2.add("c");
		list2.add("b");
		
		//find the duplicates
		List<String> duplicates = new ArrayList<>();
		
		//remove the duplicates
		//aporach 1 :
		System.out.println("Removing duplicates from two lists :");
		for (String string : list2) {
			list1.remove(string);
		}
		System.out.println("Approach 1: Final lists are : ");
		System.out.println(list1);
		System.out.println(list2);
		
		//aproach 2:
		list1.removeAll(list2);
		System.out.println("Approach 2: Final lists are : ");
		System.out.println(list1);
		System.out.println(list2);
	}

}