package com.core.java8.streams.to;

public class Person {
	String firstName;
	String lastName;
	public String name;
    public int age;
    
    public Person() {
    	System.out.println("Person: Default constructor called!");
	}
    
    public Person(String fName, String lName){
    	this.firstName = fName;
    	this.lastName = lName;
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Person(String fName, String lastName, int age) {
        this.firstName = fName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
    public String toString() {
        return this.name;
    }
}