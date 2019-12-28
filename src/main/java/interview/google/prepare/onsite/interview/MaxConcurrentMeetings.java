package interview.google.prepare.onsite.interview;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There are many meeting during day. Given a list all meetings startTime and endTime, find the max meetings which overlap
 * in some time.
 * 我的解法就是对所有的时间点先排序，并区分start and end，then sweep line from the 1st time spot to the last one, start should +1, end should -1
 * follow-up: if there are huge data for intervals and could not be put one machines.
 * 我想到了mapReducer, 但是在如何split source data的时候答得不是很清楚，最后他的意思是每一个server都产生24个count，每一个count是针对
 * 一个小时的，然后再aggregate them，在aggregate them 的时候，只要把每个server上24小时的count都分别加起来，找一个最大值就可以了
 * 比如 0：00 到1：00的时间段，把所有servers上的count都加起来。把1小时当成1个unit。
 * 但我当时考虑的一个问题是如果一个meeting跨越多个小时，在把它分到多个servers上的时候会不会有重复计算，隔了一天想明白了,
 * 因为每个log只有一个log，所以不会有重复的记录在两个servers上
 */
public class MaxConcurrentMeetings {

  public int maxConcurrent(List<Interval> intervals) {
    // first extrace the intervals to timespot
    List<TimeSpot> list = new ArrayList<>();
    for (Interval i : intervals) {
      list.add(new TimeSpot(i.start, true));
      list.add(new TimeSpot(i.end, false));
    }

    // 2nd sort all timespot based on time and isStart
    Collections.sort(list, (o1, o2) -> o1.time.compareTo(o2.time)==0 ?
        // Boolean compare will guarantee false < true, so Boolean.compare(true, false) == 1,
        // Boolean.compare(false, true) == -1,
        Boolean.compare(o1.isStart, o2.isStart) : o1.time.compareTo(o2.time));

    // count the concurrent and find the max
    int max = 0, count = 0;
    for (TimeSpot timeSpot : list) {
      if (timeSpot.isStart) count++;
      else count--;
      max = Math.max(count, max);
    }

    return max;
  }

  static class Interval {
    LocalTime start, end;

    Interval(LocalTime s, LocalTime e) {
      start = s;
      end = e;
    }
  }

  class TimeSpot {
    LocalTime time;
    boolean isStart;

    public TimeSpot(LocalTime time, boolean isStart) {
      this.time = time;
      this.isStart = isStart;
    }
  }

  public static void main(String... args) {
    System.out.println(Boolean.compare(true, false));
    List<Interval> intervals = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    intervals.add(new Interval(LocalTime.parse("02:00", formatter), LocalTime.parse("04:00", formatter)));
    intervals.add(new Interval(LocalTime.parse("01:00", formatter), LocalTime.parse("14:00", formatter)));
    intervals.add(new Interval(LocalTime.parse("02:00", formatter), LocalTime.parse("05:00", formatter)));
    intervals.add(new Interval(LocalTime.parse("05:00", formatter), LocalTime.parse("08:00", formatter)));
    intervals.add(new Interval(LocalTime.parse("06:00", formatter), LocalTime.parse("09:00", formatter)));
    intervals.add(new Interval(LocalTime.parse("03:00", formatter), LocalTime.parse("07:00", formatter)));
    intervals.add(new Interval(LocalTime.parse("06:30", formatter), LocalTime.parse("11:00", formatter)));

    MaxConcurrentMeetings maxConcurrentMeetings = new MaxConcurrentMeetings();
    System.out.println(maxConcurrentMeetings.maxConcurrent(intervals));
  }

}
