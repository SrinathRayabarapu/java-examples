package com.core.java8.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstrates Java 8 Functional Interfaces and Lambda expressions.
 * 
 * <p>A Functional Interface is an interface with exactly one abstract method.
 * The key concept is passing code (behavior) as a parameter, enabling
 * functional programming in Java.</p>
 * 
 * <h3>Key Concepts:</h3>
 * <ul>
 *   <li><b>@FunctionalInterface</b> - Optional annotation that helps compiler enforce the single abstract method rule</li>
 *   <li><b>Lambda Expressions</b> - Concise way to implement functional interfaces</li>
 *   <li><b>Default Methods</b> - Allowed in functional interfaces since they have implementations</li>
 *   <li><b>Static Methods</b> - Also allowed in functional interfaces</li>
 * </ul>
 * 
 * <h3>Lambda Syntax:</h3>
 * <pre>{@code
 * // No parameters
 * () -> System.out.println("Hello");
 * 
 * // Single parameter (parentheses optional)
 * x -> x * 2
 * 
 * // Multiple parameters
 * (x, y) -> x + y
 * 
 * // With block body
 * (x, y) -> {
 *     int sum = x + y;
 *     return sum;
 * }
 * }</pre>
 *
 * @author Srinath.Rayabarapu
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 * @see java.util.function.Consumer
 */
@Slf4j
public class FunctionalInterfaceMain {
	
	/**
	 * Demonstrates traditional anonymous class vs lambda expression approaches
	 * for implementing functional interfaces.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		
		//traditional way of working : prior to Java 8
		carryOutWork(new SimpleFunctionalInterface() {
			@Override
			public void doWork() {
				log.info("Works in traditional way too!");
			}
		});
		
		//lambda way of working
		// doWork method doesn't take a params
		SimpleFunctionalInterface sf1 = () -> log.info("Works in Lambda!");
		sf1.doWork();
		sf1.defaultMethod();

	}
	
	/**
	 * Executes the work defined in the given functional interface.
	 * 
	 * <p>This method demonstrates how functional interfaces can be passed
	 * as parameters, allowing for flexible behavior injection.</p>
	 *
	 * @param sfi the functional interface implementation to execute
	 */
	public static void carryOutWork(SimpleFunctionalInterface sfi) {
		sfi.defaultMethod();
		sfi.doWork();
	}
}

/**
 * A simple functional interface demonstrating the core concept.
 * 
 * <p>The {@code @FunctionalInterface} annotation is optional but recommended.
 * It helps the compiler verify that the interface has exactly one abstract method.
 * Without the annotation, the interface can still be used as a functional interface
 * if it meets the criteria.</p>
 * 
 * <p>Default and static methods are allowed because they already have implementations
 * and don't count towards the "single abstract method" rule.</p>
 *
 * @author Srinath.Rayabarapu
 */
@FunctionalInterface
interface SimpleFunctionalInterface	{

	/**
	 * Default method with a pre-defined implementation.
	 * 
	 * <p>Default methods were introduced in Java 8 to allow interface evolution
	 * without breaking existing implementations. They're allowed in functional
	 * interfaces because they don't affect the single abstract method contract.</p>
	 */
	default void defaultMethod(){
		System.out.println("Hey.. I'm default method!");
	}

	/**
	 * The single abstract method that makes this a functional interface.
	 * 
	 * <p>This method must be implemented by any class implementing this interface,
	 * or can be provided via a lambda expression or method reference.</p>
	 */
	void doWork();
}