package com.google.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * To achieve O(1) time in getRandom, we have to keep a ArrayList which can use get(index) to return a random element.
 * Could not use {@link java.util.LinkedHashSet} or {@link java.util.LinkedHashMap} because both of them do not have get
 * method.
 */
public class RandomizedSet {
  List<Integer> list;
  HashMap<Integer, Integer> map;
  Random random = new Random();

  /** Initialize your data structure here. */
  public RandomizedSet() {
    /**
     * must use ArrayList instead of LinkedList, because we need more get than remove or insert, use ArrayList can improve
     * performance.
     */
    list = new ArrayList();
    map = new HashMap();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (map.containsKey(val)) return false;
    map.put(val, list.size());
    list.add(val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element.
   * need swap last element to the removed element in list to keep all other elements index. Otherwise we remove an element
   * in the middle of the list will shift all right elements, so the HashMap val-location pair screw up
   */
  public boolean remove(int val) {
    if (!map.containsKey(val)) return false;
    int index = map.get(val);
    if (index!=list.size()-1) {
      int last = list.get(list.size()-1);
      map.put(last, index);
      list.set(index, last);
    }
    list.remove(list.size()-1);
    map.remove(val);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int rand = random.nextInt(list.size());
    return list.get(rand);
  }
}
