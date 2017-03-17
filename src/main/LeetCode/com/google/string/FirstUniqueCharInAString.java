package com.google.string;

/**
 * Created by ychang on 3/13/2017.
 */
public class FirstUniqueCharInAString {
  public int firstUniqChar(String s) {
    /**
     * use Array instead of HashMap to save time
     */
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c-'a']++;
    }
    for (int i=0; i<s.length(); i++) {
      if (count[s.charAt(i)-'a']==1) return i;
    }
    return -1;
  }
}
