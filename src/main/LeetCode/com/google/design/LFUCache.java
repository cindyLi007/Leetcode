package com.google.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ychang on 3/17/2017. Must have a Frequency TreeMap to record freq nodes, it should be increasing order by freq.
 * Each time we use key to find the freq, then update Freq TreeMap to update each item correct freq order
 */
public class LFUCache {
  private TreeMap<Integer, List<Integer>> freqMap; // freq - key pair
  private Map<Integer, int[]> valueMap; // key - [value, freq] pair
  private final int MAX_ENTRIES;

  public LFUCache(int capacity) {
    MAX_ENTRIES =capacity;
    freqMap = new TreeMap<>();
    valueMap = new HashMap();
  }

  public int get(int key) {
    int res=-1;
    if (valueMap.containsKey(key)) {
      int[] entry = valueMap.get(key);
      res=entry[0];
      updateFreqMap(key, res);
    }
    return res;
  }

  public void put(int key, int value) {
    if (MAX_ENTRIES==0) return;
    if (valueMap.containsKey(key)) {
      updateFreqMap(key, value);
    } else {
      valueMap.put(key, new int[]{value, 1});
      /**
       * we must first check and remove EXISTING entry in freqMap BEFORE we add the new one, otherwise, we will delete
       * the just-added one
       */
      if (valueMap.size()>MAX_ENTRIES) {
        /**
         * we use TreeMap, firstEntry is the least frequency list, and we guarantee there is no "Empty-List" entry
         */
        valueMap.remove(freqMap.firstEntry().getValue().remove(0));
      }
      freqMap.computeIfAbsent(1, k -> new LinkedList()).add(key);
    }
  }

  private void updateFreqMap(int key, int value) {
    int[] entry = valueMap.get(key);
    valueMap.put(key, new int[]{value, entry[1] + 1});
    freqMap.get(entry[1]).remove(new Integer(key));
    // must remove empty-list freq entry
    if (freqMap.get(entry[1]).isEmpty())
      freqMap.remove(entry[1]);
    freqMap.computeIfAbsent(entry[1] + 1, k -> new LinkedList()).add(key);
  }

}
