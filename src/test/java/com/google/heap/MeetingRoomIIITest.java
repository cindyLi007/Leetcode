package com.google.heap;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by ychang on 10/10/2017.
 */
public class MeetingRoomIIITest {
  @Test
  public void meetingRoomSchedule() throws Exception {
    // Given
    MeetingRoomIII meetingRoomIII = new MeetingRoomIII();
    List<Interval> list = new ArrayList<>();
    list.add(new Interval(10, 12));
    list.add(new Interval(10, 11));
    list.add(new Interval(11, 12));
    list.add(new Interval(13, 14));

    // When
    List<List<int[]>> res = meetingRoomIII.meetingRoomSchedule(list);
  }

}