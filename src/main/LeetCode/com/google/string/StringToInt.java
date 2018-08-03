package com.google.string;

/**
 * Created by ychang on 8/6/2017.
 */
public class StringToInt {
  // Time: O(N)
  public int myAtoi(String s) {
    if (s==null || s.length()==0) {
      return 0;
    }

    int i=0, neg=1, N=s.length();
    while (i<N && s.charAt(i)==' ') {
      i++;
    }
    if (i==N) {
      return 0;
    }

    if (s.charAt(i)=='-' || s.charAt(i)=='+') {
      if (s.charAt(i++)=='-') neg=-1;
    }

    int res=0;
    for (; i<s.length(); i++) {
      char c = s.charAt(i);
      if (!Character.isDigit(c)) {
        return res*neg;
      }

      int digit = c-'0';
      // (res*10+digit>Integer.MAX_VALUE) also apply for negative case, because if res*10+digit > Integer.MAX_VALUE,
      // that means -(res*10+digit) <= Integer.MIN_VALUE, we also should stop
      if (res>(Integer.MAX_VALUE-digit)/10) {
        return neg==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      res = res*10 + digit;
    }
    return res*neg;

  }
}
