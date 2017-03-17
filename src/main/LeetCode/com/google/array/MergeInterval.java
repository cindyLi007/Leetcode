package com.google.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 1/4/2017.
 * Create a new list is faster than change the passed list. And set primitive var start and end is faster to change list
 * element's start and end values.
 */
public class MergeInterval {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals==null || intervals.size()<=1)
      return intervals;
    Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
    int start = intervals.get(0).start, end = intervals.get(0).end;
    List<Interval> result = new LinkedList();
    for (int i = 1; i<intervals.size(); i++) {
      Interval cur = intervals.get(i);
      if (cur.start<=end) {
        end = Math.max(end, cur.end);
      } else {
        result.add(new Interval(start, end));
        start = cur.start;
        end = cur.end;
      }
    }
    // must add the last interval here
    result.add(new Interval(start, end));
    return result;
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