package com.core.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {
	public static void main(String[] args) {
		Locale mylocal = new Locale("te");
		Locale.setDefault(mylocal);

		ResourceBundle r = ResourceBundle.getBundle("dictionary", mylocal);
		System.out.println(r.getString("goodmorning"));
		System.out.println(r.getString("fine"));
		System.out.println(r.getString("Good night"));
	}
}
