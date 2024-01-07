package com.core.cloning;

/**
 * cloneable Sheep
 * 
 * @author srayabar
 *
 */
public class Sheep implements Cloneable {
	
	String name;// primitive property
	String color;

	public Sheep() {
	}

	public Sheep(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	public Object getClone() {
		try {
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	
	@Override
	public String toString() {		
		return "{" + getName() +", " + getColor() + "}";
	}
}
