package com.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {

	/*
	
	^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$

	Explanation:
	^                 # start-of-string
	(?=.*[0-9])       # a digit must occur at least once
	(?=.*[a-z])       # a lower case letter must occur at least once
	(?=.*[A-Z])       # an upper case letter must occur at least once
	(?=.*[@#$%^&+=])  # a special character must occur at least once
	(?=\S+$)          # no whitespace allowed in the entire string
	.{8,}             # anything, at least eight places though
	$                 # end-of-string
 	 */
	 
	public static void main(String[] args) {
		
		String emailIdRegex = "^[\\w_.]+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
		Pattern pattern = Pattern.compile(emailIdRegex);
		Matcher matcher = pattern.matcher("sjdskjd@gmail.cp");
		System.out.println(matcher.matches());
	}

	private Pattern pattern;
	private Matcher matcher;

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	/**
	 * Validate password with regular expression
	 * 
	 * @param password password for validation
	 * @return true valid password, false invalid password
	 */
	public boolean validate(final String password) {
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

}