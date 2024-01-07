package com.core.generics;

public class FootBall {
	
	private String teamName;
	public FootBall(String teamName) {
		this.teamName = teamName;
	}
	
	@Override
	public String toString() {
		return teamName;
	}

}