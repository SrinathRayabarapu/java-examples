package com.java.test.runner;

import org.junit.*;

/**
 * demo class for all JUnit annotations 
 * 
 * @author srayabar
 *
 */
public class JUnitAnnotation {
	
	@BeforeClass
	public static void BeforeClassMethod(){
		System.out.println("In BeforeClassMethod");
	}
	
	@AfterClass
	public static void AfterClassMethod(){
		System.out.println("In AfterClassMethod");
	}
	
	@Before
	public void BeforeMethod(){
		System.out.println("In BeforeMethod");
	}
	
	@After
	public void AfterMethod(){
		System.out.println("In AfterMethod");
	}
	
	@Test
	public void Test1Method(){
		System.out.println("In TestMethod1");
	}
	
	@Test
	public void Test2Method(){
		System.out.println("In TestMethod2");
	}
	
	@Ignore //this will not be executed
	public void IgnoreMethod(){
		System.out.println("In IgnoreMethod");
	}
	
}