package com.google.string;

/**
 * Created by ychang on 8/6/2017.
 */
public class StringToInt {
  public int myAtoi(String str) {
    if (str==null || str.length()==0 || str.trim().length()==0)
      return 0;
    // String.trim() can remove leading and tailing whitespaces
    str = str.trim();
    char[] ch = str.toCharArray();
    int i = 0;
    if (ch[0]=='-' || ch[0]=='+')
      i++;
    int neg = ch[0]=='-' ? -1 : 1;
    int res = 0;
    for (; i<ch.length; i++) {
      if (ch[i]<'0' || ch[i]>'9')
        return res*neg;
      int digit = ch[i] - '0';
      if (res>(Integer.MAX_VALUE - digit)/10) {
        if (neg==1)
          return Integer.MAX_VALUE;
        else
          return Integer.MIN_VALUE;
      }
      res = res*10 + (ch[i] - '0');
    }
    return neg*res;
  }
}
