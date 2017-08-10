package com.google.design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ychang on 12/8/2016.
 * this question also tag as design, so make all class member private and for window SIZE and list make them final,
 * make sum long to hold more integers. the performance has no difference with using array or linked list
 */
public class MovingAverage {
  private final int WINDOW_SIZE;
  private final Deque<Integer> list;
  private long sum;

  /**
   * Initialize your data structure here.
   */
  public MovingAverage(int size) {
    WINDOW_SIZE = size;
    list = new LinkedList();
    sum = 0;
  }

  public double next(int val) {
    if (list.size()==WINDOW_SIZE)
      sum -= list.poll();
    sum += val;
    list.offer(val);
    return (double) sum/list.size();
  }
}
