package com.cgi.localdate.time.zone;

import static java.lang.System.out;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.temporal.TemporalAdjusters.next;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by ychang on 7/5/2016.
 */
public class LocalDateExample {
  public static void main(String[] args) {
    LocalDate now, bDate, nowPlusMonth, nextTues;

    now = LocalDate.now();
    out.println("now is " + now.format(ofPattern("MM-dd-yyyy")));

    bDate = LocalDate.of(1995, Month.MAY, 23);
    out.println("Java's bDate is " + bDate);
    out.println("Java's bDate is before now " + bDate.isBefore(now));
    out.println("Java's bDate is in a leap year " + bDate.isLeapYear());
    out.println("Java's bDate is " + bDate.getDayOfWeek());

    nowPlusMonth = now.plusMonths(1);
    out.println("The date a month from now is " + nowPlusMonth);
    nextTues = now.with(next(THURSDAY));
    out.println("Next Tuesday is date " + nextTues);

//    monday16(now);
  }

  private static void monday16(LocalDate now) {
    int count=0;
    for (LocalDate date = now.plusDays(10); date.isBefore(now.plusYears(23)); date = date.plusMonths(1)) {
      if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
        out.println(date);
        count++;
      }
    }
    out.println(count);
  }
}
