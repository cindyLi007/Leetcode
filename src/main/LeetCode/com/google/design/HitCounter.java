package com.google.design;

/**
 * Created by ychang on 3/31/2017.
 */
public class HitCounter {
  int[] count;
  int start, sum;

  /** Initialize your data structure here. */
  public HitCounter() {
    count = new int[300];
    start = 1;
    sum = 0;
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    count[(timestamp-start)%300]++;
    sum++;
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    if (timestamp-start>=300) {
      for (; start<timestamp-299; start++) {
        sum-=count[start%300];
        count[start%300]=0;
      }
    }
    return sum;
  }
}
