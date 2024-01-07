package com.core.java8.lambda.predicates;

import com.core.java8.streams.to.Person;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Predicate examples to demo it's capabilities
 * 
 * @author srayabar
 *
 */
public class PredicatesAndOthers {
	
	public static void main(String[] args) {
		
		Predicate<String> predicate = (s) -> s.length() > 0;//boolean valued single argument function
		
		boolean test = predicate.test("abc");//default methods
		System.out.println(test);
		
		boolean test2 = predicate.negate().test("abc");//default methods
		System.out.println(test2);
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		
		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		
		Predicate<Person> personPred = p -> p.getName().equalsIgnoreCase("srinath");
		
		Function<String, Integer> toInteger = Integer::valueOf;//accept one argument and produce result
		Function<String, Integer> toInteger1 = (s) -> {
			return 0;
		};
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		String apply = backToString.apply("123");
		System.out.println(apply);
		
		
		Supplier<Person> personSupplier = Person::new;//produces result for a generic type
		personSupplier.get();
		
		
		Consumer<Person> greeter = (p) -> System.out.println("Hello " + p.getName());//represents operations to be performed on single element
		greeter.accept(new Person("srinath", 25));
		
		
		Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());//advanced comparator
		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");
		
		int compare = comparator.compare(p1, p2);
		System.out.println((compare == 0) ? "John and Alice are equal" : ((compare < 0) ? "John is lesser than Alice" : ((compare > 0) ? "John is greater than Alice" : "why are you here?") ));
		
		
		Optional<String> optional = Optional.of("bam");//utility method to avoid infamous NPE
		
		System.out.println(optional.isPresent());//checks null
		System.out.println(optional.get());
		System.out.println(optional.orElse("fallback"));//returns value or passed value
		
		optional.ifPresent((s) -> System.out.println(s.charAt(0)) );
		
	}

}