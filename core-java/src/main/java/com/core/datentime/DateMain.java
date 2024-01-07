package com.core.datentime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateMain {

	/**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

		/*
		 * TimeZone timezone = TimeZone.getTimeZone("Europe/Paris");
		 * 
		 * Date date = new Date(); // your date Calendar cal =
		 * Calendar.getInstance(timezone);
		 * 
		 * Calendar calendar =
		 * Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid")); Date
		 * currentDate = calendar.getTime();
		 * 
		 * System.out.println(currentDate);
		 */
        DateFormat df = DateFormat.getDateInstance(DateFormat.DATE_FIELD, Locale.FRANCE);

		Date date = new Date(new Long("1386898984141"));
		System.out.println("Forming Date object from millis : ");
		System.out.println(date);

		// 1386056624141
		// Tue Dec 03 13:13:44 IST 2013

		/*
		 * DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * 
		 * // Use Madrid's time zone to format the date in
		 * df.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss Z");
		 * 
		 * System.out.println("Date and time in Madrid: " + df.format(date));
		 */
		
		DateFormat originalFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = originalFormat.parse("02 Feb 2016 06:29:27");
		String formattedDate = targetFormat.format(date);  // 20120821
		
        System.out.println(formattedDate);

        df = new SimpleDateFormat("yyyy-MM-dd");

        Date date2 = new Date(0L);
        System.out.println(df.format(date2));

		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
	}

}
