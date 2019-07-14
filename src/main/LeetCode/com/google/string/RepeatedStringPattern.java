package com.google.string;

/**
 * Created by ychang on 1/5/2017.
 * For len 1 to len = (length of str)/2, try to find whether this is a string starting from index 0 can be repeated
 * through the whole string.
 */
 public class RepeatedStringPattern {
  /**
   * For example AB is a string (A, B represent a substring), now we append AB to AB, so new string is ABAB
   * If we remove leading A and tailing B, it changes to BA. Only B part equals to A part, we can have a same string,
   * which mean AB is a repeated string
   */
  public boolean repeatedSubstringPattern_simple(String str) {
    String s = str+str;
    return s.substring(1, s.length()-1).indexOf(str)>=0;
  }

  // Time: O(N^2)
  public boolean repeatedSubstringPattern_test(String s) {
    int N = s.length();
    // from the longer substring, it can save time, for example, aaaaaaaa
    for (int i=N/2; i>=1; i--) {
      // i is the len of substring, only when str.length can be divided by substring's length, we check
      // this check can significantly improve performance
      if (N%i!=0) continue;
      String sub = s.substring(0, i);
      int j=i;
      while (j+i <= N && s.substring(j, j+i).equals(sub)) {
        j+=i;
      }
      // if finish the whole string with the repeated substring, means we find one.
      if (j==N) return true;
    }
    return false;
  }
}
