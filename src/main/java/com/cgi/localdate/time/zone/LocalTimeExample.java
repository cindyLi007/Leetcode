package com.cgi.localdate.time.zone;

import static java.lang.System.out;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalTime;

/**
 * Created by ychang on 7/7/2016.
 */
public class LocalTimeExample {

  public static void main(String[] args) {
    LocalTime now, nowPlus, nowHrsMins, lunch, bedtime;

    now = LocalTime.now();
    out.println("The time now is " + now.format(ofPattern("HH:mm:ss")));

    nowPlus = now.plusHours(1).plusMinutes(15);
    out.println("What time is it 1 hour 15 mins from now " + nowPlus.format(ofPattern("HH:mm:ss")));

    nowHrsMins = now.truncatedTo(MINUTES);
    out.println("Truncate the current time to minutes " + nowHrsMins);
    out.println("It is the  " + now.toSecondOfDay()/60 + "th minute");

    lunch = LocalTime.of(12, 30);
    out.println("Is lunch is my future? " + lunch.isAfter(now));

    long minsToLunch = now.until(lunch, MINUTES);
    out.println("Minutes till lunch " + minsToLunch);

    bedtime = LocalTime.of(22, 0);
    long hrsToBedtime = now.until(bedtime, HOURS);
    out.println("How many hours until bedtime " + hrsToBedtime);
  }
}
