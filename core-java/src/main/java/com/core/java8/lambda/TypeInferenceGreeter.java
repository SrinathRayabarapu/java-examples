package com.core.java8.lambda;

/**
 * to understand TypeInference of a Functional Interface
 * 
 * @author srayabar
 *
 */
public class TypeInferenceGreeter {

	private void greet(Greeting greeting) {
		greeting.sayHi();
	}
	
	public static void main(String[] args) {
		TypeInferenceGreeter inferenceGreeter = new TypeInferenceGreeter();
		
		//anonymous inner class way of representing functional interface
		Greeting greeting = new Greeting() {
			@Override
			public void sayHi() {
				System.out.println("Hello Subbamma!!");
			}
		};
		inferenceGreeter.greet(greeting);
		
		//creating a functional interface where interface should have a single method declaration
		Greeting greeting2 = () -> System.out.println("Hello Subbamma again..!!");
		inferenceGreeter.greet(greeting2);
	}
}

interface Greeting{
	public void sayHi();
}