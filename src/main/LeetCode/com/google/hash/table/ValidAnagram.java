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
}
