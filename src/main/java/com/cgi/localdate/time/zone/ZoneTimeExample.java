package com.cgi.localdate.time.zone;

import static java.lang.System.out;
import static java.time.Month.JUNE;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by ychang on 7/7/2016.
 */
public class ZoneTimeExample {

  public static void main(String[] args) {
    ZoneId SFO = ZoneId.of("America/Los_Angeles");
    ZoneId BOS = ZoneId.of("America/New_York");
    ZoneId BLR = ZoneId.of("Asia/Calcutta");

    LocalDateTime departure = LocalDateTime.of(2014, JUNE, 13, 22, 30);
    ZonedDateTime departSFO = ZonedDateTime.of(departure, SFO);
    out.println("Flight 123 departure SFO at: " + departSFO);

    ZonedDateTime departTimeAtBOS = departSFO.toOffsetDateTime().atZoneSameInstant(BOS);
    out.println("Local time BOS at departure : " + departTimeAtBOS);
    out.println("Flight time: 5 hours 30 minutes");

    ZonedDateTime arriveBOS = departSFO.plusHours(5).plusMinutes(30).toOffsetDateTime().atZoneSameInstant(BOS);
    out.println("Flight 123 arrived BOS: " + arriveBOS);

    ZonedDateTime arrivedTimeAtSFO = arriveBOS.toOffsetDateTime().atZoneSameInstant(SFO);
    out.println("Local time SFO at arrival: " + arrivedTimeAtSFO);
    out.println();
  }
}
