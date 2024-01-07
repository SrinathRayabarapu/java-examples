package com.core.java8.lambda.predicates;

import com.core.java8.streams.to.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate is a functional interface which accepts any Type(T) and returns a boolean value.
 * 
 * @author srayabar
 */
public class PredicatesMain {
	
	public static void main(String[] args) {
		
		//Predicate takes a param and returns a boolean
		Predicate<Person> personAgePred = p ->
				(p.getAge() > 21
						&& p.getFirstName().equalsIgnoreCase("rayabarapu"));
		
		List<Person> personsList = Arrays.asList(
				new Person("rayabarapu", "srinath", 32),
				new Person("rayaba", "srinath", 32), 
				new Person("rrapu", "srinath", 32),
				new Person("rayabarapu", "srinath", 32), 
				new Person("abarapu", "srinath", 32),
				new Person("rayabarapu", "srinath", 32), 
				new Person("rayabarapu", "srinath", 32),
				new Person("sdsd", "srinath", 32)
				);
				
		List<Person> filteredPersons = personsList.stream()
				.filter(personAgePred)
				.collect(Collectors.toList());
		
		filteredPersons.forEach(p -> System.out.println(p.getFirstName()));
	}

}