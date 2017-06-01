package com.google.string;

/**
 * Created by ychang on 4/28/2017.
 */
public class MinWindowSubstring {
  public String minWindow(String s, String t) {
    int[] map = new int[256];
    for (char c : t.toCharArray()) {
      map[c]++;
    }
    int left=0, right=0, count=t.length(), res=Integer.MAX_VALUE;
    String str="";
    while (right<s.length()) {
      char c = s.charAt(right++);
      /**
       * no matter whether a char in the map, update map
       */
      map[c]--;
      // if map[c]>=0 mean we hit a char in T
      if (map[c]>=0) count--;

      while (count==0) {
        if (right-left<res) {
          res=right-left;
          str=s.substring(left, right);
        }
        // kick out one char from left
        c=s.charAt(left++);
        map[c]++;
        if (map[c]>0) count++;
      }
    }
    return str;
  }
}
