package com.core.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * we create a custom annotation with @interface and add mandatory retention and target
 * 
 * Method declarations must not have any parameters or a throws clause. Return types are restricted to primitives, String, 
 * Class, enums, annotations, and arrays of the preceding types.
 * 
 * @author srayabar
 *
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface TestAnnotation {
	
	//should ignore this test?
	public boolean enabled() default true;

}