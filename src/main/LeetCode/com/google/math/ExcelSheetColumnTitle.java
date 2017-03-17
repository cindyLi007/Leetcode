package com.google.math;

/**
 * Created by ychang on 3/12/2017.
 */
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    char[] array = "ZABCDEFGHIJKLMNOPQRSTUVWXY".toCharArray();
    StringBuilder sb = new StringBuilder();
    while (n!=0) {
      sb.insert(0, array[n%26]);
      n=(n-1)/26;
    }
    return sb.toString();
  }
}
