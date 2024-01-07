package com.core.generics;

public class Cricket {
	
	private String teamName;
	
	public Cricket(String teamName) {
		this.teamName = teamName;
	}
	
	@Override
	public String toString() {
		return teamName;
	}

}
