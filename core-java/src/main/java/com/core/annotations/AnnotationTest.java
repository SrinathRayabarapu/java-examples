package com.core.annotations;

import com.core.annotations.TesterInfoAnnotation.Priority;

@TesterInfoAnnotation(
	priority = Priority.HIGH,
	createdBy = "srinath",
	tags = {"test", "practice"}
)
public class AnnotationTest {
	
	@TestAnnotation
	void testA() {
		if(true)
			throw new RuntimeException("always fails!");		
	}
	
	@TestAnnotation(enabled = false)
	void testB() {
		if(false)
			throw new RuntimeException("always passes!");
	}

	@TestAnnotation(enabled = true)
	void testC() {
		if(10 > 1) {
			//do nothing, this will always passes
		}
	}
	
}