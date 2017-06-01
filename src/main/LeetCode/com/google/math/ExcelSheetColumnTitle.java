package com.google.math;

/**
 * Created by ychang on 3/12/2017.
 */
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n!=0) {
      /**
       * 'A'+--n%26 is int, need cast it to char, could not use String.valueOf, that only convert it to a String int,
       * such as "65"
       */
      sb.insert(0, (char)('A'+--n%26));
      n/=26;
    }
    return sb.toString();
  }
}
