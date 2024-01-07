package com.util;

import java.util.Calendar;

public class DateCaluclator {

	public static void main(String[] args) {

		// pass the number of months here
		int i = 17; // observe im passing 3 moths, like wise u can pass any
					// number
		getDate(i);

	}

	private static void getDate(int i) {

		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);

		System.out.println(year + " : " + month + " : " + day);

		cal.add(Calendar.MONTH, -i);

		int m_year = cal.get(Calendar.YEAR);
		int m_month = cal.get(Calendar.MONTH);
		int m_day = cal.get(Calendar.DATE);

		System.out.println(m_year + " : " + m_month + " : " + m_day);

	}

}
