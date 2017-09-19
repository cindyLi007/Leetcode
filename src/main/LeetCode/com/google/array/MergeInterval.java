package com.google.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 1/4/2017.
 * Create a new list is faster than change the passed list. And set primitive var start and end is faster to change list
 * element's start and end values.
 */
public class MergeInterval {
  /**
   * this one can beat only 5%
   */
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

  /**
   * this one can beat 92%, similar with meeting room II
   * {@link com.google.heap.MeetingRoomII}
   */
  public List<Interval> merge_faster(List<Interval> intervals) {
    if (intervals==null || intervals.size()==0) return intervals;
    int n=intervals.size();
    /**
     * we need not to care whether array start and array end pair matches,
     */
    int[] start=new int[n], end=new int[n];
    for (int i=0; i<n; i++) {
      start[i]=intervals.get(i).start;
      end[i]=intervals.get(i).end;
    }
    Arrays.sort(start);
    Arrays.sort(end);
    List<Interval> res = new LinkedList();
    for (int i=0, j=0; i<n; i++) {
      // j is start, i is end, each time we compare the next interval's start with current's end.
      if (i==n-1 || start[i+1]>end[i]) {
        res.add(new Interval(start[j], end[i]));
        j=i+1;
      }
    }
    return res;
  }
}

class Interval {
  int start;
  int end;

  Interval(int s, int e) {
    start = s;
    end = e;
  }
}