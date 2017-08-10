package com.google.math;

/**
 * Created by ychang on 8/9/2017.
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit. For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class AddDigits {
  public int addDigits(int num) {
    int count=0;
    while (num>=10) {
      while (num>0) {
        count+=num%10;
        num/=10;
      }
      num=count;
      count=0;
    }
    return num;
  }

  public int addDigits_formula(int num) {
    /**
     * this is a formula, the digit root of an integer is dr(n) = 1 + (n - 1) % 9
     */
    return 1 + (num-1)%9;
  }
}
