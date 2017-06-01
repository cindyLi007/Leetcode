package com.google.linked.list;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 5/10/2017.
 */
public class InsertInterval {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new LinkedList();
    int i = 0;
    while (i<intervals.size() && intervals.get(i).end<newInterval.start)
      res.add(intervals.get(i++));
    int j = intervals.size() - 1;
    while (j>=0 && intervals.get(j).start>newInterval.end)
      res.add(i, intervals.get(j--));
    if (res.size()!=intervals.size()) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(j).end);
    }
    res.add(i, newInterval);
    return res;
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