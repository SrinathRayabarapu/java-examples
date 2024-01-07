package com.core.io;

/**
 * EmployeeEntity class which has name, age and designation as properties
 *
 * @author srinath.rayabarapu
 */
public class Employee {
	public String name = "";
	public String designation = "";
	public int age = 0;

	public Employee(String name, String designation, int age) {
		this.name = name;
		this.designation = designation;
		this.age = age;
	}

	public String toString() {
		return name + " : " + designation;
	}
}
