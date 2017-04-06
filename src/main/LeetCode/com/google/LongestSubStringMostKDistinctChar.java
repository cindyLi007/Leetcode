package com.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 11/21/2016.
 */
public class LongestSubStringMostKDistinctChar {
  public static void main(String[] args) {
    int result = lengthOfLongestSubstringKDistinct_2("eceba", 2);
    System.out.println(result);
  }

  /**
   * this can beat 30%
   */
  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    int start = 0, i = 0, res = 0;
    Map<Character, Integer> map = new HashMap();
    while (i<s.length()) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.size()>k) {
        res = Math.max(res, i - start);
        // shift start
        for (int j = start; j<=i; j++) {
          char ch = s.charAt(j);
          if (map.get(ch)==1) {
            map.remove(ch);
            start = j + 1;
            break;
          } else {
            map.put(ch, map.get(ch) - 1);
          }
        }
      }
      i++;
    }
    return Math.max(i - start, res);
  }

  /**
   * this can beat 93%
   */
  public static int lengthOfLongestSubstringKDistinct_2(String s, int k) {
    int[] map = new int[256];
    int left=0, right=0, count=0, res=0;
    char[] ch = s.toCharArray();
    while (right<ch.length) {
      if (map[ch[right]]++==0) count++;
      if (count>k) {
        while (left<=right) {
          map[ch[left]]--;
          if (map[ch[left++]]==0) break;
        }
        count--;
      }
      res=Math.max(res, right-left+1);
      right++;
    }
    return res;
  }
}
