package com.core.java8.lambda;

import com.core.java8.streams.to.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * demos new java8 collections iteration capabilities
 */
public class CollectionIterationExample {
	
	public static void main(String[] args) {
		List<Person> personsList = Arrays.asList(
				new Person("rayaarapu", "srinth", 32),
				new Person("rayaba", "srinath", 32), 
				new Person("rrapu", "srinath", 32),
				new Person("rayabarapu", "srinath", 32), 
				new Person("abarapu", "srinath", 32),
				new Person("rayabarapu", "srinath", 32), 
				new Person("rayabarapu", "srinath", 32),
				new Person("sdsd", "srinath", 32)
				);

		System.out.println(".....................old way.....................");
		//traditional for-in loop, these are external iterators
		for (Person person : personsList) {
			System.out.println(person.toString());
		}
		
		System.out.println(".....................new way.....................");
		personsList.forEach(p -> System.out.println(p)); //lambda

		personsList.forEach(System.out::println); //method reference / shortcut / not parallel
		
		System.out.println(".....................extra.....................");

		Predicate<Person> pred = (p) -> p.getFirstName().startsWith("r");

		personsList
		.stream()
		//.filter((p) -> p.getFirstName().startsWith("r"))
				.filter(pred)
		.forEach(System.out::println);
		
		long count = personsList
		//.stream()
		.parallelStream()
		.filter((p) -> p.getFirstName().startsWith("r"))
		.count();
		
		System.out.println(count);
		
	}

}