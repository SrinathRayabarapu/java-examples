package com.core.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

public class Annotations {
	
	public static void main(String[] args) {
		
		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint);                   // null

		Hints hints1 = PersonOne.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2

		Hint[] hints2 = PersonOne.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length); 
		
	}

}

@interface Hints {
	Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint{
	String value();
}

@Hints({@Hint("hint1"), @Hint("hint2")}) //old school
class Person{
}

@Hint("hint1")
@Hint("hint2")
class PersonOne{//new way
}

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@interface MyAnnotation {}
