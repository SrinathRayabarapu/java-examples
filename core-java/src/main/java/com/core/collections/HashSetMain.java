package com.core.collections;

import java.util.HashSet;

/**
 * different scenarios on HashSet
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class HashSetMain {

	public static void main(String[] args) {

		HashSet<Integer> hashSet = new HashSet<>();

		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(null);
		hashSet.add(null);

		System.out.println(hashSet.size());

		for (Integer integer : hashSet) {
			System.out.println(integer);
		}

	}

}