package com.google.math;

/**
 * Created by ychang on 5/7/2017.
 * a n-len int multiply a m-len int, the result length <=(n+m), we create a int[n+m], for ith digit in N multiply jth digit in M
 * the result is in pos[i+j] and pos[i+j+1].
 *
 * O(N*M)
 */
public class MultiplyString {
  public String multiply(String num1, String num2) {
    char[] ch1 = num1.toCharArray(), ch2 = num2.toCharArray();
    int[] res = new int[ch1.length + ch2.length];
    for (int i = ch1.length - 1; i >= 0; i--) {
      for (int j = ch2.length - 1; j >= 0; j--) {
        res[i + j + 1] += (ch1[i] - '0') * (ch2[j] - '0');
        res[i + j] += res[i + j + 1] / 10;
        res[i + j + 1] %= 10;
      }
    }
    /* From a space perspective, it is better to incrementally add the terms rather than compute all of them individually and then add them up
     * see line 15, 16
      int carry = 0;
      for (int i = res.length - 1; i >= 0; i--) {
        int sum = res[i] + carry;
        res[i] = sum % 10;
        carry = sum / 10;
      }
    */
    // remove leading 0
    int firstNonZero = 0;
    while (firstNonZero < res.length && res[firstNonZero] == 0)
      firstNonZero++;
    if (firstNonZero == res.length)
      return "0";
    StringBuilder sb = new StringBuilder();
    for (int i = firstNonZero; i < res.length; i++) {
      sb.append(res[i]);
    }
    return sb.toString();
  }
}
