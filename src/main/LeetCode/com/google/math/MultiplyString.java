package com.google.math;

/**
 * Created by ychang on 5/7/2017.
 * a n-len int multiply a m-len int, the result length <=(n+m), we create a int[n+m], for ith digit in N multiply jth digit in M
 * the result is in pos[i+j] and pos[i+j+1].
 */
public class MultiplyString {
  public String multiply(String num1, String num2) {
    int len1 = num1.length(), len2 = num2.length();
    int[] pos = new int[len1 + len2];
    num1 = new StringBuilder(num1).reverse().toString();
    num2 = new StringBuilder(num2).reverse().toString();
    for (int i = 0; i<len2; i++) {
      int op1 = num2.charAt(i) - '0';
      for (int j = 0; j<len1; j++) {
        int op2 = num1.charAt(j) - '0';
        int res = op1*op2 + pos[i + j];
        pos[i + j] = res%10;
        pos[i + j + 1] += res/10;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = pos.length - 1; i>=0; i--) {
      /**
       * try to find the first non-zero digit, which is the most-significant digit
       */
      if (sb.length()>0 || pos[i]!=0)
        sb.append(pos[i]);
    }
    return sb.length()==0 ? "0" : sb.toString();
  }
}
