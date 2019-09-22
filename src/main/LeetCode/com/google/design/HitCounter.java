package com.google.design;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by ychang on 9/17/2019, this one could not pass leetcode OJ
 */
public class HitCounter {
  int count, start;
  // map store for a timestamp, how many counts
  TreeMap<Integer, Integer> map;

  /** Initialize your data structure here. */
  public HitCounter() {
    count=0;
    start=1;
    map = new TreeMap();
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  // Time: O(1)
  public void hit(int timestamp) {
    count++;
    map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  // Time: O(lgN)
  public int getHits(int timestamp) {
    if (timestamp - start >= 300) {
      SortedMap<Integer, Integer> headMap = map.headMap(timestamp - 300, true);
      for (Map.Entry<Integer, Integer> entry : headMap.entrySet()) {
        count -= entry.getValue();
        map.remove(entry.getKey());
      }
    }
    start = timestamp - 300 + 1;
    return count;
  }

  /*
  private int[] times;
  private int[] hits;

  public HitCounter() {
    times = new int[300];
    hits = new int[300];
  }

  // Time: O(1)
  public void hit(int timestamp) {
    int index = timestamp%300;
    if (times[index]!=timestamp) {
      times[index] = timestamp;
      hits[index] = 1;
    } else {
      hits[index]++;
    }
  }

  // Time: O(N)
  public int getHits(int timestamp) {
    int total = 0;
    for (int i = 0; i<300; i++) {
      if (timestamp - times[i]<300) {
        total += hits[i];
      }
    }
    return total;
  }
  */

}
