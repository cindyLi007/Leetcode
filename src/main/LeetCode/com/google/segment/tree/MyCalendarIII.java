package com.google.segment.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

class MyCalendarThree {
  List<int[]> intervals;

  public MyCalendarThree() {
    intervals = new ArrayList<>();
  }

  public int book(int start, int end) {
    int[] i = new int[]{start, end};
    int index = Collections.binarySearch(intervals, i, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o1[0]);
    return 0;
  }
}