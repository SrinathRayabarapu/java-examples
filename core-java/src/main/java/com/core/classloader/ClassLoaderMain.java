package com.core.classloader;

import com.core.java8.streams.to.Person;

/**
 * demos classloader examples like dynamic loading etc
 * 
 * @author srayabar
 *
 */
public class ClassLoaderMain {

	//loaded by application classloader 
	public static void main(String[] args) {
		
		try {
			
			//only loads class in to classloader
			Class<?> forName = Class.forName("com.core.java8.streams.to.Person");
			System.out.println("Class invoked : " + forName.getName());
			
			//alternative to (new operator, not Same!) and always calls zero argument constructor
			Object newInstance = forName.newInstance();
			System.out.println("Instance created. : " + ((Person)newInstance));
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}