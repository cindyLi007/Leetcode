package com.google.design;

import java.util.*;

class LFU {
  Map<Integer, Integer> values;
  Map<Integer, Integer> counts;
  // could not use TreeMap to satisfy O(1), TreeMap firstEntry() is O(lgN)
  // value use LinkedHashSet to guarantee that the least referred item is in first entry
  Map<Integer, LinkedHashSet<Integer>> freqMap;
  // use min to track the min freq currently
  int min=0;
  int capacity;

  public LFU(int capacity) {
    values = new HashMap();
    counts = new HashMap();
    freqMap = new HashMap();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!values.containsKey(key)) return -1;
    int count = counts.get(key);
    counts.put(key, count+1);
    freqMap.get(count).remove(key);
    if (freqMap.get(count).size()==0) {
      freqMap.remove(count);
      if (count==min) min++;
    }
    freqMap.computeIfAbsent(count+1, o->new LinkedHashSet()).add(key);
    return values.get(key);
  }

  public void put(int key, int value) {
    if (capacity==0) return;
    if (values.containsKey(key)) {
      values.put(key, value);
      get(key);
    } else {
      if (values.size()==capacity) {
        LinkedHashSet<Integer> set = freqMap.get(min);
        Integer k = set.iterator().next();
        set.remove(k);
        if (set.size()==0) freqMap.remove(min);
        values.remove(k);
        counts.remove(k);
      }
      values.put(key, value);
      counts.put(key, 1);
      min = 1;
      freqMap.computeIfAbsent(1, o->new LinkedHashSet()).add(key);
    }
  }

  public static void main(String... args) {
    LFU lfu = new LFU(2);
    lfu.put(1, 1);
    lfu.put(2, 2);
    int res = lfu.get(1);
    System.out.println(res);
    lfu.put(3, 3);
    System.out.println(lfu.get(2));
    System.out.println(lfu.get(3));
    lfu.put(4, 4);
    System.out.println(lfu.get(1));
    System.out.println(lfu.get(3));
    System.out.println(lfu.get(4));
  }
}
