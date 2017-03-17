package com.google.hash.table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ychang on 2/10/2017.
 * Keep a HashMap abb -> word_set pair, put all words have same abbr into same entry.
 * When check is unique, if the word in not in the set or the set only contains one word which is thw word, return true
 */
public class ValidWordAbbr {
  Map<String, Set<String>> map;

  public ValidWordAbbr(String[] dictionary) {
    map = new HashMap();
    for (String word : dictionary) {
      String key = getKey(word);
      if (!map.containsKey(key)) {
        map.put(key, new HashSet());
      }
      map.get(key).add(word);
    }
  }

  public boolean isUnique(String word) {
    String key = getKey(word);
    /**
     * HashSet does NOT have get() method, but there is only one item in the set, can directly use contains
     */
    return !map.containsKey(key) || map.get(key).size()==1 && map.get(key).contains(word);
  }

  private String getKey(String word) {
    int len = word.length();
    /**
     * please notice, could not use String.replace(substring(1, len-1)) because for ddc, it will return 11c (also substitute first d
     */
    return len>2 ? word.charAt(0)+ String.valueOf(len-2) + word.charAt(len-1) : word;
  }
}
