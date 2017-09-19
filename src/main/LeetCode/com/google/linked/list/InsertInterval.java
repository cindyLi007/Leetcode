package com.google.linked.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ychang on 5/10/2017.
 */
public class InsertInterval {
  /**
   * this can beat 95%
   */
  public List<Interval> insert_inorder(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new LinkedList();
    int i = 0;
    while (i<intervals.size() && intervals.get(i).end<newInterval.start)
      res.add(intervals.get(i++));
    int j = intervals.size() - 1;
    while (j>=0 && intervals.get(j).start>newInterval.end)
      res.add(i, intervals.get(j--));
    // must have this check to guarantee newInterval is in the middle of intervals and need merge with some interval and intervals is not empty
    if (res.size()!=intervals.size()) {
      newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(j).end);
    }
    res.add(i, newInterval);
    return res;
  }

  /**
   * this method is similar with {@link com.google.heap.MeetingRoomII}, this can beat 48%
   */
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (intervals.size()==0) {
      intervals.add(newInterval);
      return intervals;
    }
    int n=intervals.size();
    int[] start=new int[n+1], end=new int[n+1];
    for (int i=0; i<n; i++) {
      start[i]=intervals.get(i).start;
      end[i]=intervals.get(i).end;
    }
    start[n]=newInterval.start;
    end[n]=newInterval.end;
    Arrays.sort(start);
    Arrays.sort(end);
    List<Interval> res = new ArrayList();
    for (int i=0, j=0; i<=n; i++) {
      if (i==n || start[i+1]>end[i]) {
        res.add(new Interval(start[j], end[i]));
        j=i+1;
      }
    }
    return res;
  }

  /**
   * Use Binary search to find i and j, then merge and insert newInterval
   * this can beat 11%, if we use a new List to copy intervals, can increase to 85%
   */
  public List<Interval> insert_BS(List<Interval> intervals, Interval newInterval) {
    // find i which is the smallest interval which end>=newInterval.start
    int i=findIndex(intervals, newInterval.start, true);
    // find j which is the smallest interval which start<=newInterval.end
    int j=findIndex(intervals, newInterval.end, false);
    /**
     * if i>j, means newInterval does not have duplicated area with intervals, we can directly insert it to intervals
     */
    if (i<=j) {
      newInterval.start=Math.min(newInterval.start, intervals.get(i).start);
      newInterval.end=Math.max(newInterval.end, intervals.get(j).end);
      int s=(j-i);
      for (int z=0; z<=s; z++) {
        intervals.remove(i);
      }
    }
    intervals.add(i, newInterval);
    return intervals;
  }

  /**
   * @param left true means we want to find the smallest interval which end>=interval.start
   *             false means we want to find the smallest interval which start<=interval.end
   * @return the index
   */
  private int findIndex(List<Interval> intervals, int v, boolean left) {
    int l=0, r=intervals.size()-1;
    while (l<=r) {
      int m=l+(r-l)/2, val= left ? intervals.get(m).end : intervals.get(m).start;
      if (val==v) return m;
      else if (val<v) l=m+1;
      else r=m-1;
    }
    return left ? r+1 : l-1;
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