package com.mockito.ex2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	// @InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	MathApplication mathApplication = new MathApplication();

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;
	
	@Before
	public void setUp(){
	}
	
	@Test
	public void testAdd() {
		// add the behavior of calc service to add two numbers
		when(this.calcService.add(10.0, 20.0)).thenReturn(30.00);

		// test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		
		//verify call to calcService is made or not with same arguments.
		verify(calcService).add(10.0, 20.0);
		verify(calcService).add(10.0, 21.0);//will fail to verify
	}
}
