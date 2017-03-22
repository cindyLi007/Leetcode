package com.google.hash.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 2/7/2017. Using HashMap to keep char -> latest index
 */
public class LongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int left = 0, right=0, res = 0;
    Map<Character, Integer> map = new HashMap();
    while (right<s.length()) {
      char c = s.charAt(right);
      if (map.containsKey(c)) {
        /**
         * must compare left and current repeating char next index, for example "abba" when go to last 'a', now left is
         * 2, map(c)+1 is 1, we should use left instead of map.get(c)+1
         */
        left = Math.max(map.get(c) + 1, left);
      }
      map.put(c, right++);
      res = Math.max(res, right - left);
    }
    return res;
  }
}
