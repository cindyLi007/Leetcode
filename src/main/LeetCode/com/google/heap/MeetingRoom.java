package com.google.heap;

import java.util.Arrays;

/**
 * Created by ychang on 4/27/2017.
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine
 * if a person could attend all meetings.
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 */
public class MeetingRoom {
  public boolean canAttendMeetings(Interval[] intervals) {
    if (intervals.length<2)
      return true;
    Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
    /**
     * need NOT keep maxEnd, because if prev satisfies (i+1).start>=(i).end, (i+1).end is always the maxEnd
     */
    for (int i = 1; i<intervals.length; i++) {
      if (intervals[i].start<intervals[i - 1].end)
        return false;
    }
    return true;
  }
}
