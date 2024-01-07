package com.core.java8.lambda;

public interface FunctionalInterfaces {
	
	public static void main(String[] args) {
		
		//functional interface is used as a lambda
		Converter<String, Integer> converterOld = (from) -> Integer.valueOf(from);//elaborated way		
		Converter<String, Integer> converter = Integer::valueOf;//simplified
		Integer convert = converter.convert("123");
		System.out.println(convert);
		
		//doSomething() method should match with lambda expression
		TestInterface inter = () -> System.out.println("Hello World!");
		inter.doSomeThing();
		
		
	}
}

/**
 * functional interface must have exactly one abstract method
 * 
 * @author srayabar
 *
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
interface Converter<F, T>{
	T convert(F from);
}


interface TestInterface {
	void doSomeThing();
}