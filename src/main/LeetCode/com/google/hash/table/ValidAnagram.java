package com.google.hash.table;

import java.util.Arrays;

/**
 * Created by ychang on 2/9/2017.
 */
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    char[] sCharArray = s.toCharArray();
    char[] tCharArray = t.toCharArray();
    Arrays.sort(sCharArray);
    Arrays.sort(tCharArray);
    return String.valueOf(sCharArray).equals(String.valueOf(tCharArray));
  }

  public boolean isAnagram_hashMap(String s, String t) {
    if (s.length()!=t.length()) return false;
    int[] hash= new int[26];
    for (char c : s.toCharArray()) {
      hash[c-'a']++;
    }
    for (char c: t.toCharArray()) {
      hash[c-'a']--;
      if (hash[c-'a']<0) return false;
    }
    return true;
  }
}
