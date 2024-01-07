package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapAssociateValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		// map for storing key and value pairs
		IdentityHashMap<Integer, String> hashMap = new IdentityHashMap<Integer, String>();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));

		String string;
		System.out.println("Enter first integer object value ");
		string = bufferedReader.readLine();
		Integer integer = Integer.parseInt(string);
		System.out.println("Enter first integer object message ");
		string = bufferedReader.readLine();
		hashMap.put(integer, string);

		System.out.println("Enter second integer object value ");
		string = bufferedReader.readLine();
		integer = Integer.parseInt(string);
		System.out.println("Enter second integer object message ");
		string = bufferedReader.readLine();
		hashMap.put(integer, string);

		System.out.println("Enter third integer object value ");
		string = bufferedReader.readLine();
		integer = Integer.parseInt(string);
		System.out.println("Enter third integer object message ");
		string = bufferedReader.readLine();
		hashMap.put(integer, string);

		System.out.println("HashMap : " + hashMap);
		System.out.println("Entry Set : " + hashMap.entrySet());

		Set set = hashMap.entrySet();
		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			System.out.println("Key : " + me.getKey() + " Value : "
					+ me.getValue());
		}
	}
}