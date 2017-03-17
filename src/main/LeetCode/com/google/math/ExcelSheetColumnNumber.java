package com.google.math;

/**
 * Created by ychang on 3/12/2017.
 */
public class ExcelSheetColumnNumber {
  public int titleToNumber(String s) {
    if (s==null || s.length()==0) return 0;
    int res=0;
    for (int i=s.length()-1, j=0; i>=0; i--, j++) {
      int num = (s.charAt(i)-'A'+1) * (int)Math.pow(26,j);
      res+=num;
    }
    return res;
  }
}
