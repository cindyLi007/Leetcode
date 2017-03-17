package com.google.string;

/**
 * Created by ychang on 1/5/2017.
 * For len 1 to len = (length of str)/2, try to find whether this is a string starting from index 0 can be repeated
 * through the whole string.
 */
public class RepeatedStringPattern {
  public boolean repeatedSubstringPattern(String str) {
    // from the longer substring, it can save time, for example, aaaaaaaa
    for (int i = str.length()/2; i>0; i--) {
      // i is the len of substring, only when str.length can be divided by substring's length, we check
      if (str.length()%i==0) {
        String sub = str.substring(0, i);
        int j = i;
        // Stride is current substring's length
        for (; j<=str.length() - i; j += i) {
          // if found a non-match string, start over from next length substring
          if (!sub.equals(str.substring(j, j + i)))
            break;
        }
        // if finish the whole string with the repeated substring, means we find one.
        if (j==str.length())
          return true;
      }
    }
    return false;
  }

  /**
   * For example AB is a string (A, B represent a substring), now we append AB to AB, so new string is ABAB
   * If we remove leading A and tailing B, it changes to BA. Only B part equals to A part, we can have a same string,
   * which mean AB is a repeated string
   */
  public boolean repeatedSubstringPattern_simple(String str) {
    String s = str+str;
    return s.substring(1, s.length()-1).indexOf(str)>=0;
  }
}
