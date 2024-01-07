package com.core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * class to accept any game type to add to list and print them back.
 *
 * @param <T>
 */
public class League<T> {
	
	private String leagueName;
	public League(String leagueName) {
		this.leagueName = leagueName;
	}
	
	private List<T> list = new ArrayList<>();
	
	public void add(T t) {
		list.add(t);
	}
	
	public void print() {
		System.out.println("League : " + this.leagueName);
		list.forEach(t-> System.out.println(t.toString()));
	}
	
}
