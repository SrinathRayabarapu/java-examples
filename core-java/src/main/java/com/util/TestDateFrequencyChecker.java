package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Check a date whether it meets different conditions or not
 */
public class TestDateFrequencyChecker {

	public static void main(String[] arg) throws ParseException {

		System.out.println("Please enter a date(dd-MMM-yyyy) : ");
		Scanner scanner = new Scanner(System.in);
		String inputDate = scanner.nextLine();

		DateFrequencyChecker(inputDate);
	}

	/**
	 * Checks whether a given date falls with in range of business conditions or
	 * not
	 * 
	 * @param inputDate
	 */
	public static void DateFrequencyChecker(String inputDate) {

		StringBuffer result = new StringBuffer("");
		Calendar calendar = Calendar.getInstance();
		int user_day = 0;
		int user_date = -1;
		int user_month = -1;
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		Date date;
		int lastDate = 0;

		if (validateDate(inputDate)) {

			try {
				date = (Date) formatter.parse(inputDate);
				calendar.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			System.out.println("User entered time : " + calendar.getTime());

			user_day = calendar.get(Calendar.DAY_OF_WEEK);
			user_month = calendar.get(Calendar.MONTH);
			user_date = calendar.get(Calendar.DAY_OF_MONTH);

			// gives last date of the month
			lastDate = calendar.getActualMaximum(Calendar.DATE);

			// checking all conditions
			result.append(checkDaily(user_day));
			result.append(checkWeekly(user_day));
			result.append(checkMidMonthly(user_date, lastDate));
			result.append(checkMonthly(user_date, lastDate));
			result.append(checkQuarterlySemiAnnual(user_month, user_date));

			System.out.println(result.toString());
		} else
			System.out.println("Entered date is wrong, Please try again ");
	}

	/**
	 * Checks whether the given date is correct or not
	 * 
	 * @param dateStr
	 * @return boolean
	 */
	private static boolean validateDate(String dateStr) {

		String formatStr = "dd-MMM-yyyy";

		SimpleDateFormat df = new SimpleDateFormat(formatStr);

		if (formatStr.trim().length() != df.toPattern().length())
			return false;

		try {
			df.parse(dateStr.trim());
		} catch (Exception e) {
			return false;
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return true;
	}

	/**
	 * checking for daily
	 * 
	 * @param user_day
	 * @return String
	 */
	private static String checkDaily(int user_day) {
		StringBuffer buffer = new StringBuffer("");
		if (!(user_day == Calendar.SUNDAY || user_day == Calendar.SATURDAY)) {
			buffer.append("Daily ");
		}
		return buffer.toString();
	}

	/**
	 * checking for weekly
	 * 
	 * @param user_day
	 * @return String
	 */
	private static String checkWeekly(int user_day) {
		StringBuffer buffer = new StringBuffer("");
		if (user_day == Calendar.MONDAY) {
			buffer.append(",Weekly ");
		}
		return buffer.toString();
	}

	/**
	 * checking for mid monthly
	 * 
	 * @param user_date
	 * @param lastDate
	 * @return String
	 */
	private static String checkMidMonthly(int user_date, int lastDate) {
		StringBuffer buffer = new StringBuffer("");
		if (user_date == 15 || user_date == lastDate) {
			buffer.append(",Mid-Monthly ");
		}
		return buffer.toString();
	}

	/**
	 * checking for monthly
	 * 
	 * @param user_date
	 * @param lastDate
	 * @return String
	 */
	private static String checkMonthly(int user_date, int lastDate) {
		StringBuffer buffer = new StringBuffer("");
		// checking for monthly
		if (user_date == lastDate) {
			buffer.append(",Monthly ");
		}
		return buffer.toString();
	}

	/**
	 * checking for Quarterly and Semi-Annual
	 * 
	 * @param user_month
	 * @param user_date
	 * @return String
	 */
	private static String checkQuarterlySemiAnnual(int user_month, int user_date) {
		StringBuffer buffer = new StringBuffer("");

		switch (user_month) {
		case Calendar.MARCH:
			if (user_date == 31)
				buffer.append(",Quarterly ");
			break;
		case Calendar.JUNE:
			if (user_date == 30) {
				buffer.append(",Quarterly ");
				buffer.append(",Semi Annual");
			}
			break;
		case Calendar.SEPTEMBER:
			if (user_date == 30)
				buffer.append(",Quarterly ");
			break;
		case Calendar.DECEMBER:
			if (user_date == 31) {
				buffer.append(",Quarterly ");
				buffer.append(",Semi Annual");
			}
			break;
		default:
			break;
		}
		return buffer.toString();
	}
}
