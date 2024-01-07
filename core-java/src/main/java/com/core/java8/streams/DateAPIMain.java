package com.core.java8.streams;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO - practice on more date apis
 *
 * @author Srinath.Rayabarapu
 */
public class DateAPIMain {

    public static void main(String[] args) {

        //finding max and min of LocalDate
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());

        // Get Min or Max Date -----------------
        LocalDate maxDate = dates.stream().max(Comparator.comparing(LocalDate::toEpochDay)).get();
        LocalDate minDate = dates.stream().min(Comparator.comparing(LocalDate::toEpochDay)).get();

        System.out.println("maxDate = " + maxDate);
        System.out.println("minDate = " + minDate);

    }

}
