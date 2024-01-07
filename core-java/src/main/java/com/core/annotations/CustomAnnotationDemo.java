package com.core.annotations;

/**
 * program to create a custom annotation </br>
 * 
 * demo example from : https://www.mkyong.com/java/java-custom-annotations-example/
 * 
 * @author srayabar
 *
 */
public class CustomAnnotationDemo {
	
	public static void main(String[] args) {
		
		int passed = 0, failed = 0, ignore = 0;
		
		//using reflection, reading back the properties of annotation
		Class<AnnotationTest> obj = AnnotationTest.class;
		
		if(obj.isAnnotationPresent(TesterInfoAnnotation.class)) {
			
			TesterInfoAnnotation annotation = obj.getAnnotation(TesterInfoAnnotation.class);
			System.out.printf("%nPriority :%s", annotation.priority());
			System.out.printf("%nCreatedBy :%s", annotation.createdBy());
			System.out.printf("%nTags :");
			
			int length = annotation.tags().length;
			for(String tag : annotation.tags()) {
				if(length > 1) {
					System.out.print(tag + ",");
				} else {
					System.out.println(tag);
				}
			}
			length--;
		}
	}
	
}
