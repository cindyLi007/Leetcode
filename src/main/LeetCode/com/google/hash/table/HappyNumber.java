package com.google.hash.table;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ychang on 2/7/2017.
 * Should use check loop to see whether it is a happy number. It finally can go into a loop, either 1 or
 * loops endlessly in a cycle which does not include 1.
 */
public class HappyNumber {
  /**
    Regular method, beat 20%
   */
  public boolean isHappy(int n) {
    if (n<=0)
      return false;
    Set<Integer> set = new HashSet();
    while (n!=1) {
      if (set.contains(n))
        return false;
      set.add(n);
      int sum = 0;
      while (n>0) {
        int digit = n%10;
        n /= 10;
        sum += Math.pow(digit, 2);
      }
      n = sum;
    }
    return true;
  }

  /**
   * beat 80%, because we need not keep a HashSet.
   */
  public boolean isHappy_best(int n) {
    if (n<=0)
      return false;
    int slow=n, fast=square(n);
    while (slow!=fast) {
      slow=square(slow);
      fast=square(square(fast));
    }
    if (slow!=1) return false;
    return true;
  }

  private int square(int n) {
    int sum=0;
    while (n>0) {
      int digit = n%10;
      n/=10;
      sum+=Math.pow(digit, 2);
    }
    return sum;
  }
}
