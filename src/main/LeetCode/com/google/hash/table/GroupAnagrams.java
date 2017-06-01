package com.google.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ychang on 2/9/2017.
 */
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap();
    for (String str : strs) {
      char[] c = str.toCharArray();
      Arrays.sort(c);
      String s = String.valueOf(c);
      if (!map.containsKey(s)) {
        // ArrayList can be faster than LinkedList
        map.put(s, new ArrayList());
      }
      map.get(s).add(str);
    }
    /**
     * ArrayList or LinkedList constructor can take Collection<? extends E> as parameter
     */
    return new ArrayList(map.values());
  }
}
