package com.google.string;

/**
 * Created by ychang on 4/24/2017.
 */
public class AddBinary {
  public String addBinary(String a, String b) {
    int lenA=a.length(), lenB=b.length();
    if (lenB>lenA) return addBinary(b, a);
    StringBuilder sb = new StringBuilder();
    int car=0, i=lenA-1, j=lenB-1;
    while (i>=0 || j>=0 || car>0) {
      int sum = (i>=0 ? a.charAt(i--)-'0' : 0) + (j>=0 ? b.charAt(j--)-'0' : 0) + car;
      car=sum/2;
      sum%=2;
      // using append instead of insert, can improve performance
      sb.append(sum);
    }
    return sb.reverse().toString();
  }
}
