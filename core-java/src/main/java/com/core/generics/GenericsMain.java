package com.core.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Demonstrates Java Generics - type-safe programming with parameterized types.
 * 
 * <p>Generics enable types (classes and interfaces) to be parameters when defining
 * classes, interfaces, and methods. This provides stronger type checks at compile time
 * and eliminates the need for type casting.</p>
 * 
 * <h3>Key Concepts Demonstrated:</h3>
 * <ul>
 *   <li><b>Generic Classes</b> - Classes with type parameters (e.g., GenericType&lt;T&gt;)</li>
 *   <li><b>Generic Methods</b> - Methods with their own type parameters</li>
 *   <li><b>Bounded Type Parameters</b> - Restricting types with extends/super</li>
 *   <li><b>Multiple Type Parameters</b> - Classes/methods with multiple types (e.g., Pair&lt;K, V&gt;)</li>
 *   <li><b>Type Inference</b> - Compiler automatically determines type arguments</li>
 * </ul>
 * 
 * <h3>Bounded Wildcards:</h3>
 * <ul>
 *   <li><b>Upper Bounded</b> - {@code <? extends Number>} accepts Number or any subclass</li>
 *   <li><b>Lower Bounded</b> - {@code <? super Integer>} accepts Integer or any superclass</li>
 *   <li><b>Unbounded</b> - {@code <?>} accepts any type</li>
 * </ul>
 * 
 * <h3>PECS Principle:</h3>
 * <p>Producer Extends, Consumer Super - Use extends when you only get values out,
 * use super when you only put values in.</p>
 *
 * @author Srinath.Rayabarapu
 * @see GenericType
 * @see Pair
 * @see GenericMethodUtil
 */
public class GenericsMain {
	
	/**
	 * Main method demonstrating various generics features.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		
		GenericType<Integer> iob = new GenericType<>(20);
		iob.showType();
		Integer ob = iob.getOb();
		System.out.println("Value of ob : " + ob);
		
		System.out.println();

		Pair<Integer, String> p1 = new Pair<>(1, "apple");
		Pair<Integer, String> p2 = new Pair<>(2, "ball");
		boolean compareBool = GenericMethodUtil.compare(p2, p1);
		System.out.println("Boolean value : " + compareBool);

		// in this case java will infer and pass List<String> to below method call
		GenericMethodUtil.processList(Collections.emptyList());

		List<Integer> intList = Arrays.asList(1, 2, 3, 4);
		double value = GenericMethodUtil.sumOfUpperBoundList(intList);
		System.out.println("Sum Value : " + value);

		List<Double> doubleList = Arrays.asList(1.0, 2.7, 3.564, 4.9);
		value = GenericMethodUtil.sumOfUpperBoundList(doubleList);
		System.out.println("Sum Value : " + value);

		//lower bounded to Integer
		GenericMethodUtil.printLowerBoundList(intList);



	}

}
