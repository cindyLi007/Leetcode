package com.google.string;

/**
 * Created by ychang on 5/11/2017.
 * The tricky part is for 1, 10, 100, check the char next to it is greater than it (minus) or not greater than it (plus)
 */
public class RomanToInt {
  public int romanToInt(String s) {
    int res = 0;
    for (int i = 0; i<s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case 'M':
          res += 1000;
          break;
        case 'D':
          res += 500;
          break;
        case 'C':
          if (i<s.length() - 1 && (s.charAt(i + 1)=='D' || s.charAt(i + 1)=='M')) res -= 100;
          else res += 100;
          break;
        case 'L':
          res += 50;
          break;
        case 'X':
          if (i<s.length() - 1 && (s.charAt(i + 1)=='C' || s.charAt(i+1)=='L'))
            res -= 10;
          else res += 10;
          break;
        case 'V':
          res += 5;
          break;
        case 'I':
          if (i<s.length() - 1 && s.charAt(i + 1)!='I')
            res -= 1;
          else
            res += 1;
          break;
      }
    }
    return res;
  }
}
