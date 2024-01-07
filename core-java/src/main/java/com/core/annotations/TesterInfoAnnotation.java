package com.core.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)//on class level
public @interface TesterInfoAnnotation {
	
	public enum Priority{
		LOW, MEDIUM, HIGH
	}
	
	Priority priority() default Priority.MEDIUM;
	
	String[] tags() default "dev";
	
	String createdBy() default "srinath";
	
}