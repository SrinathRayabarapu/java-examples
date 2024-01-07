package com.core.java8.lambda;

import java.util.function.BiConsumer;

/**
 * demos how to catch an exception inside a lambda expression
 *
 */
public class ExceptionHandlingInLambda {
	
	public static void main(String[] args) {
		int[] someNumbers = {1, 2, 3, 4, 5};
		int key = 0;
		process(someNumbers, key, wrapperLambda((v, k) -> {
			//can put try-catch here, but will not look elegant
			System.out.println(v / k );	
		}));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			//can be put here - but should not. Keep lambdas very simple
			consumer.accept(i, key);
		}
	}
	
	//has the ability to change original lambda behavior
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (a, b) -> {
			try {
				consumer.accept(a, b);
			} catch (ArithmeticException e) {
				System.out.println("ArithmeticException caught!");
			}
			
		};
	}
}