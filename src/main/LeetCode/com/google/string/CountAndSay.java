package com.google.string;

/**
 * Created by ychang on 5/10/2017.
 */
public class CountAndSay {
  public String countAndSay(int n) {
    StringBuilder sb = new StringBuilder("1");
    for (int i=1; i<n; i++) {
      int j=0;
      StringBuilder s = new StringBuilder();
      while (j<sb.length()) {
        char prev = sb.charAt(j++);
        int count=1;
        while (j<sb.length() && sb.charAt(j)==prev) {
          j++;
          count++;
        }
        s.append(count).append(prev);
      }
      sb=s;
    }
    return sb.toString();
  }
}
