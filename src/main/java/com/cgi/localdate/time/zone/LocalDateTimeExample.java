package com.cgi.localdate.time.zone;

import static java.lang.System.out;
import static java.time.Month.MARCH;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by ychang on 7/7/2016.
 */
public class LocalDateTimeExample {

  public static void main(String[] args) {
    LocalDateTime meeting, flight, courseStart, courseEnd;

    meeting = LocalDateTime.of(2015, MARCH, 21, 13, 30);
    out.println("Meeting is on: " + meeting);

    LocalDate flightDate = LocalDate.of(2017, MARCH, 31);
    LocalTime flightTime = LocalTime.of(21, 45);
    flight = LocalDateTime.of(flightDate, flightTime);
    out.println("Flight leaves: " + flight);

    courseStart = LocalDateTime.of(2017, MARCH, 24, 9, 0);
    courseEnd = courseStart.plusDays(4).plusHours(8);
    out.println("Course starts: " + courseStart);
    out.println("Course ends: " + courseEnd);

    long courseHrs = (courseEnd.getHour() - courseStart.getHour()) *
        (courseStart.until(courseEnd, DAYS) + 1);
    out.println("Course is : " + courseHrs + " hours long");

  }
}
