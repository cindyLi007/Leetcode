package com.google.design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ychang on 3/16/2017.
 */
public class LRUCache {
  private Map<Integer, Integer> map;

  public LRUCache(int capacity) {
    /**
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @param  accessOrder     the ordering mode - true means access-order, false mean insertion-order.
     *                         be default, it is insertion order which means we will remove the earliest inserted element
     *                         no matter whether we visited after that, so we MUST set it to true to apply LRU
     * Notice if constructor is non-Generic, Map.Entry could not be generic, otherwise there is a compile error
     */
    map = new LinkedHashMap(capacity, 0.75f, true) {
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size()>capacity;
      }
    };
  }

  public int get(int key) {
    return map.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    map.put(key, value);
  }
}
