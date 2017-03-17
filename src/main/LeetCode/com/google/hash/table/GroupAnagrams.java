package com.google.hash.table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
        map.put(s, new LinkedList());
      }
      map.get(s).add(str);
    }
    return new LinkedList(map.values());
  }
}
