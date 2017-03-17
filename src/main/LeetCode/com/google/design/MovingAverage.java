package com.google.design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ychang on 12/8/2016.
 * this question also tag as design, so make all class member private and for window size and list make them final,
 * make sum long to hold more integers
 */
public class MovingAverage {
  private final int windowSize;
  private final Deque<Integer> list;
  private long sum;

  /**
   * Initialize your data structure here.
   */
  public MovingAverage(int size) {
    windowSize = size;
    list = new LinkedList();
    sum = 0;
  }

  public double next(int val) {
    if (list.size()==windowSize)
      sum -= list.poll();
    sum += val;
    list.offer(val);
    return (double) sum/list.size();
  }
}
