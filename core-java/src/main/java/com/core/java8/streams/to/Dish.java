package com.core.java8.streams.to;

public class Dish {
	
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	
	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	public enum Type{ MEAT, FISH, OTHER}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the vegetarian
	 */
	public boolean isVegetarian() {
		return this.vegetarian;
	}

	/**
	 * @return the calories
	 */
	public int getCalories() {
		return this.calories;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return this.type;
	}
	
}