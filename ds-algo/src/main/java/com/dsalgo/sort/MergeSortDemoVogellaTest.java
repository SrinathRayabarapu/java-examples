package com.dsalgo.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MergeSortDemoVogellaTest {
	
	private int[] numbers;
	private final static int SIZE = 7;
	private final static int MAX = 20;
	
	//stubbing with random integer data
	@Before
	public void setUp() throws Exception{
		this.numbers = new int[SIZE];
		Random random = new Random();
		System.out.println("Input order : ");
		for(int i=0; i<this.numbers.length; i++){
			this.numbers[i] = random.nextInt(MAX);
			System.out.print(this.numbers[i] +", ");
		}
	}
	
	@Test
	public void testMergeSort(){
		long startTime = System.currentTimeMillis();
		
		MergeSortDemoVogella sortDemo = new MergeSortDemoVogella();
		sortDemo.sort(this.numbers);
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		
		System.out.println("\nMerge Sort completed in secs- " + elapsedTime);
		System.out.println("Output order : ");
		
		for(int i=0; i<this.numbers.length-1; i++){
			System.out.print(this.numbers[i]+", ");
			if(this.numbers[i] > this.numbers[i+1]){
				fail("Should not happen! - " + this.numbers[i] + ">" + this.numbers[i+1]);
			}
		}
		assertTrue(true);
	}

}