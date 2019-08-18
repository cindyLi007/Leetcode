package com.google.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ychang on 11/21/2016.
 */
public class LongestSubStringMostKDistinctChar {

  public static void main(String[] args) {
    int result = lengthOfLongestSubstringKDistinct_stream("aa", 1);
    System.out.println(result);
  }

  public static int lengthOfLongestSubstringKDistinct_stream(String s, int k) {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(k, 1, true);
    int res = 0, start = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c) && map.size() == k) {
        res = Math.max(res, i - start);
        start = getFirstCharPos(map) + 1;
      }
      map.put(c, i);
    }
    return Math.max(res, s.length() - start);
  }

  private static Integer getFirstCharPos(LinkedHashMap<Character, Integer> map) {
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      map.remove(entry.getKey());
      return entry.getValue();
    }
    return 0;
  }

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int left=0, right=0, res=0, count=0;
    int[] map = new int[256];
    while (right<s.length()) {
      int c = s.charAt(right);
      if (map[c]==0) count++;
      map[c]++;
      while (count>k) {
        c = s.charAt(left++);
        map[c]--;
        if (map[c]==0) count--;
      }
      res=Math.max(res, right-left+1);
      right++;
    }
    return res;
  }

}
