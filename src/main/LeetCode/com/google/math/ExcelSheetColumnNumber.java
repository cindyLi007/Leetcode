package com.google.math;

/**
 * Created by ychang on 3/12/2017.
 */
public class ExcelSheetColumnNumber {
  public int titleToNumber(String s) {
    int res =0;
    for (int i=0; i<s.length(); i++) {
      int i1 = (s.charAt(i) - 'A') + 1;
      res = res*26 + i1;
    }
    return res;
  }
}
