package com.google.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 1/4/2017.
 * Create a new list is faster than change the passed list. And set primitive var start and end is faster to change list
 * element's start and end values.
 */
public class MergeInterval {
  /**
   * this one can beat only 38%
   * Time: O(NlgN), Space: O(1)
   */
  public List<Interval> merge(List<Interval> intervals) {
    intervals.sort(Comparator.comparingInt(a -> a.start));
    int i=1;
    while (i<intervals.size()) {
      if (intervals.get(i).start<=intervals.get(i-1).end) {
        intervals.get(i-1).end = Math.max(intervals.get(i-1).end, intervals.get(i).end);
        intervals.remove(i);
      } else {
        i++;
      }
    }
    return intervals;
  }

  /**
   * this one can beat 100%, similar with meeting room II
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
    for (int i=1, j=0; i<=n; i++) {
      // j is start, i is end, each time we compare the next interval's start with current's end.
      if (i==n || start[i]>end[i-1]) {
        res.add(new Interval(start[j], end[i-1]));
        j=i;
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