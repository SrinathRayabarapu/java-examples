package com.core.strings;

/**
 * demos differences between StringBuffer with final keyword and StringBuilder.
 *
 * -> StringBuffer is synchronized - slow and safe in multi threading
 * -> StringBuilder is non synchronized - fast and not safe
 *
 * @author Srinath.Rayabarapu
 * 
 */
public class StringBufferStringBuilderMain {

	public static void main(String[] args) {

//		final : references cann't be changed but the values can be(if the class allows)
		final StringBuffer stringBuffer = new StringBuffer("Hi");

//		 + is Undefined operation in StringBuffer
//		stringBuffer =  stringBuffer + new StringBuffer("bye");
		
		// allowed because there is no new reference
		stringBuffer.append(" srinath");
		
		// not allowed cause of a new reference
		//stringBuffer = new StringBuffer(" srinath");
		
		System.out.println(stringBuffer);
		
		final String a = new String("a");
		/* not allowed because there is a new string reference being pointed to old String a
		 * the + operation in strings results a new String 
		 */
		//a = a+"b";
		
		System.out.println(a);
	}

}