package com.google.string;

/**
 * Created by ychang on 5/3/2017.
 * There are 2 possibilities to satisfy one edit distance
 * 1. Replace one char (2 Strings must be same length)
 * 2. 2 Strings only have one len diff, delete one char from longer string
 */
public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    for (int i = 0; i<Math.min(s.length(), t.length()); i++) {
      if (s.charAt(i)!=t.charAt(i)) {
        if (s.length()==t.length()) // we can only replace one char, now we suppose it is char in i
          return s.substring(i + 1).equals(t.substring(i + 1));
        if (s.length()<t.length())
          return s.substring(i).equals(t.substring(i + 1));
        else
          return t.substring(i).equals(s.substring(i + 1));
      }
    }
    // if all previous chars are same, to satisfy one edit distance, 2 Strings must have 1-len diff.
    return Math.abs(s.length() - t.length())==1;
  }
}
