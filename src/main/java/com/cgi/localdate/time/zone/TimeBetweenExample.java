package com.cgi.localdate.time.zone;

import static java.lang.System.out;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by ychang on 7/7/2016.
 */
public class TimeBetweenExample {

  public static void main(String[] args) {
    String dataFormat = "MMMM d, yyyy";
    LocalDate aDate = null;

    boolean validStr = false;

    DateTimeFormatter formatter = ofPattern(dataFormat);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (!validStr) {
      out.print("Enter a date: ");
      try {
        String dateEntered = br.readLine();
        aDate = LocalDate.parse(dateEntered, formatter);
        validStr = true;
      } catch (IOException e) {
        validStr = false;
      }

      out.println("Date entered was: " + aDate.format(ofPattern("MM-dd-yyyy")));
      LocalDate now = LocalDate.now();

      Period between;
      if (aDate.isBefore(now)) {
        between = Period.between(aDate, now);
      } else {
        between = Period.between(now, aDate);
      }

      int years = between.getYears();
      int months = between.getMonths();
      int days = between.getDays();

      out.println("There are " + years + " years, " + months + " months, " + days + " days between" +
          " now and the date entered");
    }
  }
}
