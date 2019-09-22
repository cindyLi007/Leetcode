package com.google.segment.tree;

import java.util.Iterator;
import java.util.TreeSet;

// Leetcode 715,
public class RangeModule {
  TreeSet<Interval> set;

  public RangeModule() {
    set = new TreeSet();
  }

  // Time: O(N)
  public void addRange(int left, int right) {
    // first create an interval which floor of new interval
    Interval i = new Interval(0, left-1);
    // return a strictly greater than "all left of new-interval" subset
    Iterator<Interval> itr = set.tailSet(i, false).iterator();
    while (itr.hasNext()) {
      Interval next = itr.next();
      // NOTICE: could not >=, that is because start is inclusive
      if (next.start > right) break;
      left = Math.min(left, next.start);
      right = Math.max(right, next.end);
      // only iterator can remove on the fly, remove current item
      itr.remove();
    }
    set.add(new Interval(left, right));
  }

  // Time: O(lgN)
  public boolean queryRange(int left, int right) {
    // higher return the least element strictly greater than passed interval
    Interval iv = set.higher(new Interval(0, left));
    return iv!=null && iv.start <=left && right <= iv.end;
  }

  // Time: O(N)
  public void removeRange(int left, int right) {
    Interval i = new Interval(0, left-1);
    Iterator<Interval> itr = set.tailSet(i, false).iterator();
    TreeSet<Interval> todo = new TreeSet();
    while (itr.hasNext()) {
      Interval next = itr.next();
      if (next.start >= right) break;
      // now we know next.start < right, means must have overlap
      if (next.start<left)
        todo.add(new Interval(next.start, left));
      if (next.end > right)
        todo.add(new Interval(right, next.end));
      itr.remove();
    }
    set.addAll(todo);
  }

  class Interval implements Comparable<Interval>{
    int start, end;

    Interval(int s, int e) {
      start=s;
      end=e;
    }

    // this is tricky and convenient to use end as primary comparation
    public int compareTo(Interval that) {
      if (end==that.end) return start - that.start;
      return end - that.end;
    }
  }

  public static void main(String... args) {
    RangeModule rangeModule = new RangeModule();
    rangeModule.addRange(10, 20);
    rangeModule.removeRange(14, 16);
    System.out.println(rangeModule.queryRange(10, 14)); // return true
    System.out.println(rangeModule.queryRange(13, 15)); // return false
    System.out.println(rangeModule.queryRange(16, 17)); // return true

  }
}
