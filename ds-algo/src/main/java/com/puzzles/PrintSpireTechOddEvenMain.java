package com.puzzles;

import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Program to print 1 to 50 numbers. On 3 divisibles print "Spire", on 5 divisible print "Tech" 
 * on both of those divisibles print "SpireTech". Write Unit test cases for the same.
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class PrintSpireTechOddEvenMain {

	public static void main(String[] args) {

		Supplier<IntConsumer> OddEvenSupplier = () -> (i) -> {
			//System.out.println(i);
			if (i % 3 == 0 && i % 5 == 0)
				System.out.println(i + " SpireTech");
			else if (i % 3 == 0)
				System.out.println(i + " Spire");
			else if (i % 5 == 0)
				System.out.println(i + " Tech");
		};

		IntStream.range(1, 51).forEach(OddEvenSupplier.get());
	}

}