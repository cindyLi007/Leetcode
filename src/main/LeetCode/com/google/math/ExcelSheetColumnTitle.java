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
       * such as "65". title is 1-index, need use 0-index when convert to Title, so first --n. For example, 53 is "BA"
       * first 53-1 = 52, 52%26=0, so 'A'+0 is A, then 52/26=2 -> n, n-1=1 1%26=1, 'A'+1 is B
       */
      sb.insert(0, (char)('A'+--n%26));
      n/=26;
    }
    return sb.toString();
  }
}
