package com.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args) {
		new RegEx().numInseeFormat();
	}

	private void numInseeFormat() {

//		String regex = "^\\(?([0-9]{1})\\)?[-.\\s]?([0-9]{2})[-.\\s]?([0-9]{2})[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{2})$";
		String regex = "[a-z]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("dsdfsds");

		//System.out.println(matcher.replaceFirst("$1 $2 $3 $4 $5 $6"));
		
		//System.out.println(matcher.matches());


		String emailIdRegex = "^[a-zA-Z0-9](\\.?[a-zA-Z0-9_-])*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,}$";
		pattern = Pattern.compile(emailIdRegex);
		matcher = pattern.matcher("tt1@bmc.com.com.com.com.com");
		
		
		System.out.println(matcher.matches());
	}
}