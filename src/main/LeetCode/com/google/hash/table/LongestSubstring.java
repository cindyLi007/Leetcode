package com.google.hash.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 2/7/2017. Using HashMap to keep char -> latest index
 */
public class LongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int start = 0, res = 0;
    Map<Character, Integer> map = new HashMap();
    for (int i = 0; i<s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        /**
         * must compare start and current repeating char next index, for example "abba" when go to last 'a', now start is
         * 2, map(c)+1 is 1, we should use start instead of map.get(c)+1
         */
        start = Math.max(map.get(c) + 1, start);
      }
      map.put(c, i);
      res = Math.max(res, i - start + 1);
    }
    return res;
  }
}
