package com.core.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * demos brand new Date api which is comparable with Joda time lib
 *
 * @author Srinath.Rayabarapu
 * 
 */
public class DateAPI {

	public static void main(String[] args) {
		
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();//equivalent to System.currentTimeMillis()
		
		System.out.println(millis);
		
		Instant instant = clock.instant();
		Date from = Date.from(instant);//can form legacy Date object
		
		
		System.out.println(ZoneId.getAvailableZoneIds());
		
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println("Europe/Berlin - " + zone1.getRules());
		System.out.println("Brazil/East - " + zone2.getRules());

		
		LocalTime now1 = LocalTime.now(zone1);//represents a time without a timezone
		LocalTime now2 = LocalTime.now(zone2);
		
		System.out.println(now1.isBefore(now2));
		
		long between = ChronoUnit.HOURS.between(now1, now2);//useful to find hours or minuts
		System.out.println(between);
		
		long between2 = ChronoUnit.MINUTES.between(now1, now2);
		System.out.println(between2);
		
		
		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late);       // 23:59:59

		DateTimeFormatter germanFormatter =
		    DateTimeFormatter
		        .ofLocalizedTime(FormatStyle.SHORT)
		        .withLocale(Locale.GERMAN);//advanced date time formatter

		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);   // 13:37
		
		
		LocalDate today = LocalDate.now();//represents a distinct date and it's immutable
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);//returns a new object
		LocalDate yesterday = tomorrow.minusDays(2);

		LocalDate independenceDay = LocalDate.of(1947, Month.AUGUST, 15);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek);
		
		DateTimeFormatter germanFormatter1 =
			    DateTimeFormatter
			        .ofLocalizedTime(FormatStyle.MEDIUM)
			        .withLocale(Locale.GERMAN);//advanced date time formatter
		
		//LocalDate date = LocalDate.parse("24.12.2014", germanFormatter1);//not working!
		//System.out.println(date);
		
		
		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);//clubs above date and time - immutable

		DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek1);      // WEDNESDAY

		Month month = sylvester.getMonth();
		System.out.println(month);          // DECEMBER

		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);
		
		
		Instant instant1 = sylvester//LocalDateTime to Instant and legacy Date conversion
		        .atZone(ZoneId.systemDefault())
		        .toInstant();

		Date legacyDate = Date.from(instant1);
		System.out.println(legacyDate);
		
		DateTimeFormatter formatter =
			    DateTimeFormatter
			        .ofPattern("MMM dd, yyyy - HH:mm");

		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
		String string = formatter.format(parsed);
		System.out.println(string);
		
	}
}