package com.google.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ychang on 4/27/2017.
 */
public class MeetingRoomII {
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals==null || intervals.length==0) return 0;
    PriorityQueue<Integer> endList = new PriorityQueue();
    Arrays.sort(intervals, (i1, i2) -> i1.start-i2.start);
    int count=intervals.length;
    endList.add(intervals[0].end);
    for (int i=1; i<intervals.length; i++) {
      int earliestEnd = endList.peek();
      if (intervals[i].start>=earliestEnd) {
        count--;
        endList.poll();
      }
      endList.offer(intervals[i].end);
    }
    return count;
  }

  /**
   * this one is faster because PriorityQueue is a heap data structure which is slower than direct array, but the idea is same
   * Anytime we keep the earliest End_Time and compare it with next meeting's start time. If start time is later than
   * earliest End_Time, we can use that meeting room and update the earliest End_Time.
   */
  public int minMeetingRooms_fastest(Interval[] intervals) {
    int meet = intervals.length;
    int[] start = new int[meet], end = new int[meet];
    for (int i = 0; i<meet; i++) {
      start[i] = intervals[i].start;
      end[i] = intervals[i].end;
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int rooms = 0, endptr = 0;
    for (int i = 0; i<meet; i++) {
      // if the current meeting's startTime is before so-far earliest endTime, need one empty room for this meeting
      if (start[i]<end[endptr])
        rooms++;
        // else we can use the meeting which endTime = end[endptr] 'room, and go to next endTime
      else
        endptr++;
    }
    return rooms;
  }
}

class Interval {
  int start;
  int end;

  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }
}
