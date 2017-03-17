package com.google.design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ychang on 3/16/2017.
 */
public class LRUCache {
  Map<Integer, Integer> map;
  private final int MAX_ENTRIES;

  public LRUCache(int capacity) {
    MAX_ENTRIES = capacity;
    /**
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @param  accessOrder     the ordering mode - true means access-order, false mean insertion-order.
     *                         be default, it is insertion order which means we will remove the earliest inserted element
     *                         mo matter whether we visited after that, so we MUST set it to true to apply LRU
     */
    map = new LinkedHashMap(capacity, 0.75f, true) {
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return map.size()>MAX_ENTRIES;
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
