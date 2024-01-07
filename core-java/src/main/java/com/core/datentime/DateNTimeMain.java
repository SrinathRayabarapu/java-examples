package com.core.datentime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * class to perform date and time related operations.
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class DateNTimeMain {

	public static void main(String args[]) {

		// pre java 8
		Date dat = new Date();
		System.out.println(dat);

		Calendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(0);
		System.out.println(calendar.getTime());

		// post java 8
		LocalDate now1 = LocalDate.now();
		LocalDate epoch = LocalDate.ofEpochDay(0);

		System.out.println("Days: " + ChronoUnit.DAYS.between(epoch, now1));
		System.out.println("Weeks: " + ChronoUnit.WEEKS.between(epoch, now1));
		System.out.println("Months: " + ChronoUnit.MONTHS.between(epoch, now1));

		Calendar now = Calendar.getInstance();
		Calendar old = Calendar.getInstance();
		old.add(Calendar.MONTH, -6);

		long difference = now.getTime().getTime() - old.getTime().getTime();
		int daysBetween = (int) (difference / (1000 * 60 * 60 * 24));

		System.out.println("Number of days in last 6 months are : " + daysBetween);

		System.out
				.println("Number of days in last 6 months are HOLA : " + getDaysBetween(old.getTime(), now.getTime()));

	}

	public static int getDaysBetween(Date startDate, Date endDate) {
		// reset all hours mins and secs to zero on start date
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		startCal.set(Calendar.HOUR_OF_DAY, 0);
		startCal.set(Calendar.MINUTE, 0);
		startCal.set(Calendar.SECOND, 0);
		long startTime = startCal.getTime().getTime();

		// reset all hours mins and secs to zero on end date
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		endCal.set(Calendar.HOUR_OF_DAY, 0);
		endCal.set(Calendar.MINUTE, 0);
		endCal.set(Calendar.SECOND, 0);
		long endTime = endCal.getTime().getTime() + (1000 * 60);
		return (int) ((endTime - startTime) / (1000 * 60));
	}
}