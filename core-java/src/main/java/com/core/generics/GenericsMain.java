package com.core.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * class to practice generics
 *
 * @author Srinath.Rayabarapu
 */
public class GenericsMain {
	
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
